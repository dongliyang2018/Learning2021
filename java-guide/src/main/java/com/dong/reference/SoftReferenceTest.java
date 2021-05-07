package com.dong.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用测试
 */
public class SoftReferenceTest {

    //启动时，设置JVM最大使用内存20MB -Xmx20M
    public static void main(String[] args) {

        //软引用的特点：当内存足的时候不会被回收，当内存不足的时候被回收
        //应用场景：缓存
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());
        System.gc();
        try {
            //休眠，给垃圾回收器执行时间
            Thread.sleep(500);
        } catch (Exception e) {
        }
        //依然可以访问到
        System.out.println(m.get());

        byte[] b = new byte[1024 * 1024 * 10];

        //null，内存不足，被回收了
        System.out.println(m.get());
    }
}
