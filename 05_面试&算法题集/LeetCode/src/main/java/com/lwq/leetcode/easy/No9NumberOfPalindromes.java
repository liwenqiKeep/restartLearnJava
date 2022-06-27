package com.lwq.leetcode.easy;

import java.nio.charset.StandardCharsets;

/**
 * @author liwenqi
 */
public class No9NumberOfPalindromes {
    public static void main(String[] args) {

        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(-121));
    }
    public static  boolean isPalindrome(int x) {
        String xs = String.valueOf(x);
        byte[] bytes = xs.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i] != bytes[bytes.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
