package com.dong;

/**
 * 颠倒二进制位
 * @version 1.0 2021/4/23
 * @author dongliyang
 */
public class LeetCode190 {

    public static void main(String[] args) {
        LeetCode190 code = new LeetCode190();
        int n = 89;
        System.out.println(String.format("%1$32s", Integer.toBinaryString(n)).replace(' ', '0'));
        int x = code.reverseBits(n);
        System.out.println(Integer.toBinaryString(x));
    }

    public int reverseBits(int n) {
        int m_16 = 0x0000ffff;
        int m_8 = 0x00ff00ff;
        int m_4 = 0x0f0f0f0f;
        int m_2 = 0x33333333;
        int m_1 = 0x55555555;
        int b = ((n & m_16) << 16) + ((n >>> 16) & m_16);
        int c = ((b & m_8) << 8) + ((b >>> 8) & m_8);
        int d = ((c & m_4) << 4) + ((c >>> 4) & m_4);
        int e = ((d & m_2) << 2) + ((d >>> 2) & m_2);
        int f = ((e & m_1) << 1) + ((e >>> 1) & m_1);

        return f;
    }
}
