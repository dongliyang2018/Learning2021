package com.dong;

import java.util.List;
import java.util.Stack;

/**
 * 回文链表
 * @version 1.0 2021/4/21
 * @author dongliyang
 */
public class LeetCode234_02 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        LeetCode234_02 code = new LeetCode234_02();
        ListNode head = code.buildList();
        boolean palindrome = code.isPalindrome(head);
        System.out.println("palindrome = " + palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        //使用栈作为辅助
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }

        while(head != null) {
            Integer val = s.pop();
            if(head.val != val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private ListNode buildList() {
        ListNode list = new ListNode(1, new ListNode(2));
        return list;
    }
}
