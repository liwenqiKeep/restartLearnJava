package com.lwq.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liwenqi
 */
public class No12RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("D"));
    }


    public static int romanToInt(String s) {

        Map<Character,Integer> integerMap = new HashMap<>(8);
        integerMap.put('I',1);
        integerMap.put('V',5);
        integerMap.put('X',10);
        integerMap.put('L',50);
        integerMap.put('C',100);
        integerMap.put('D',500);
        integerMap.put('M',1000);
        char[] chars = s.toCharArray();
        if(chars.length == 1){
            return integerMap.get(chars[0]);
        }
        int result = 0;
        for (int i = 0; i < chars.length-1; i++) {
            if(integerMap.get(chars[i])>=integerMap.get(chars[i+1])){
                result += integerMap.get(chars[i]);
            }else {
                result = result + integerMap.get(chars[i+1]) - integerMap.get(chars[i]);
                i++;
            }
        }
        if(integerMap.get(chars[chars.length-2])>=integerMap.get(chars[chars.length-1])){
            result += integerMap.get(chars[chars.length-1]);
        }

        return result;
    }
}
