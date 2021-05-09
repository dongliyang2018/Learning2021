package com.dong;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 手写线程池
 * @version 1.0 2021/5/9
 * @author dongliyang
 */
public class MyExecutors {

    private List<WorkThread> workThreads;
    private BlockingQueue<Runnable> runnables;
    private boolean isRun;

    public MyExecutors(int maxThreadCount,int queueSize) {
        workThreads = new ArrayList<>(maxThreadCount);
        runnables = new LinkedBlockingQueue<>(queueSize);
        isRun = true;
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkThread().start();
        }
    }

    public boolean execute(Runnable task) {
        return runnables.offer(task);
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (isRun || runnables.size() > 0) {
                Runnable runnable = runnables.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyExecutors executor = new MyExecutors(2, 20);
        for (int i = 0; i < 10; i++) {
            final int val = i;
            executor.execute(() -> System.out.println("Thread:" + Thread.currentThread().getName() + ",print:" + val));
        }
//        executor.isRun = false;
    }
}

