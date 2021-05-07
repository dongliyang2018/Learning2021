package com.dong.reference;

import java.io.IOException;

/**
 * 强引用测试
 */
public class NormalReferenceTest {
    public static void main(String[] args) throws IOException {
        //强引用，也就是普通的引用
        M m = new M();
        m = null;

        //调用垃圾回收器
        System.gc();

        System.in.read();
    }
}
