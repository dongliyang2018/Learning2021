package com.dong;

public class SynchronizedDemo {

    public void method() {
        synchronized (this) {
            System.out.println("synchronized method code block");
        }
    }
}
