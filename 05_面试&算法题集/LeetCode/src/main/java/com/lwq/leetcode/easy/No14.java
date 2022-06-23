package com.lwq.leetcode.easy;

/**
 * @author liwenqi
 */
public class No14 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        String preF = "";
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        boolean flag = true;
        int index = 0;
        int a = 0;
        while (flag) {

            if (strs[a].substring(0, index).equals(strs[a + 1].substring(0, index))) {
                preF = strs[a].substring(0, index);
                a ++;
            } else {
                flag = false;
            }
            if(a > strs.length-2){
                continue;
            }
        }
        return preF;
    }
}
