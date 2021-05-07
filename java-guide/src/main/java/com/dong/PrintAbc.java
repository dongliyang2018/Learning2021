package com.dong;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PrintABC
 * @version 1.0 2021/4/24
 * @author dongliyang
 */
public class PrintAbc {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition ca = lock.newCondition();
    private static final Condition cb = lock.newCondition();
    private static final Condition cc = lock.newCondition();

    private static final CountDownLatch latchb = new CountDownLatch(1);
    private static final CountDownLatch latchC = new CountDownLatch(1);

    private static final int N = 5;
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {

            //必须先上锁，才能调用Condition的await、signal
            lock.lock();
            try {
                for (int i = 0; i < N; i++) {
                    System.out.print("A");
                    //唤醒在condtion b上等待的线程
                    cb.signal();
                    if (i == 0) {
                        //保证线程A先执行
                        latchb.countDown();
                    }
                    //当前线程在Condition a上等待
                    ca.await();
                }
                cb.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        },"ThreadA");

        Thread threadB = new Thread(() -> {
            try {
                //保证线程A先执行
                latchb.await();
            } catch (Exception e) {
            }

            lock.lock();
            try {
                for (int i = 0; i < N; i++) {
                    System.out.print("B");
                    cc.signal();
                    if (i == 0) {
                        //保证线程B先执行
                        latchC.countDown();
                    }
                    cb.await();
                }
                cc.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        },"ThreadB");

        Thread threadC = new Thread(() -> {
            try {
                //保证线程B先执行
                latchC.await();
            } catch (Exception e) {

            }

            lock.lock();

            try {
                for (int i = 0; i < N; i++) {
                    System.out.print("C");
                    ca.signal();
                    cc.await();
                }
                ca.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        },"ThreadC");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
