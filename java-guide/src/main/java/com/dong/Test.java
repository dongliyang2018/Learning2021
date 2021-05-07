package com.dong;

/**
 * @version 1.0 2021/4/21
 * @author dongliyang
 */
public class Test {
    public static void main(String[] args) {
        int n = 121;
        System.out.println(isPalindrome(n));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int n = x;
        int result = 0;
        while(n != 0) {
            int mod = n % 10;
            n = n / 10;
            result = result * 10 + mod;
            System.out.println("mod =" + mod + ",n:" + x + ",result=" + result);
        }
        return result == x;
    }
}
