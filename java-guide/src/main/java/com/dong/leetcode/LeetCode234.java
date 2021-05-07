package com.dong.leetcode;

/**
 * 回文链表
 * @version 1.0 2021/4/21
 * @author dongliyang
 */
public class LeetCode234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        LeetCode234 code = new LeetCode234();
        ListNode head = code.buildList();
        boolean palindrome = code.isPalindrome(head);
        System.out.println("palindrome = " + palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        StringBuilder forward = new StringBuilder();
        while(head != null) {
            forward.append(head.val);
            head = head.next;
        }
        return forward.toString().equals(forward.reverse().toString());
    }

    private ListNode buildList() {
        ListNode list = new ListNode(1, new ListNode(2));
        return list;
    }
}
