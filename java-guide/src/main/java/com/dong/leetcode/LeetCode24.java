package com.dong.leetcode;

public class LeetCode24 {

    public class ListNode {

        private int val;
        private ListNode next;

        public ListNode(){

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;

        while(cur.next != null && cur.next.next != null){

            ListNode next = head.next;
            ListNode tmp = head.next.next;

            cur.next = next;
            next.next = head;
            head.next = tmp;

            cur = head;
            head = head.next;
        }

        return res.next;
    }
}

