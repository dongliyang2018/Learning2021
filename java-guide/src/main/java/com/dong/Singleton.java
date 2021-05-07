package com.dong;

/**
 * 双重校验锁实现线程安全的单例类
 */
public class Singleton {

    /**
     * 使用volatile关键字修饰，作用：禁止指令重排；直接访问主内存，保证线程的可见性。
     */
    private volatile static Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance() {
        //先判断对象是否已经实例化过，没有实例化才进入加锁代码
        if (instance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
