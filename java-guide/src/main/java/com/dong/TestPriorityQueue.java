package com.dong;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 一个基于优先级堆的无界优先级队列。
 * @version 1.0 2021/4/26
 * @author dongliyang
 */
public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        minheap.add(10);
        minheap.add(8);
        minheap.add(9);
        minheap.add(11);
        minheap.add(2);

        maxheap.add(10);
        maxheap.add(8);
        maxheap.add(9);
        maxheap.add(11);
        maxheap.add(2);

        System.out.println(minheap.toString());
        System.out.println(maxheap.toString());

        System.out.println(minheap.peek());
        System.out.println(maxheap.peek());

        minheap.poll();
        maxheap.poll();

        minheap.size();
        maxheap.size();

        while (!minheap.isEmpty()) {
            System.out.println(minheap.poll());
        }
    }
}
