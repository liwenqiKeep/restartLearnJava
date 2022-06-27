package com.lwq.leetcode.easy;

/**
 * @author liwenqi
 */
public class No14 {
    public static void main(String[] args) {
        String[] arr1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr1));

        String[] arr2 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(arr2));

        String[] arr3 = {"cir", "car"};

        System.out.println(longestCommonPrefix(arr3));

        String[] arr4 = {"reflower", "flow", "flight"};

        System.out.println(longestCommonPrefix(arr4));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }
}
