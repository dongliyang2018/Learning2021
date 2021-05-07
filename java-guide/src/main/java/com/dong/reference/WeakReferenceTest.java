package com.dong.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference<M> w = new WeakReference<>(new M());

        System.out.println(w.get());
        System.gc();
        System.out.println(w.get());
    }

}
