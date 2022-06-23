package com.lwq.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liwenqi
 */
public class No1SumToNumber {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexes[0] = i;
                indexes[1] = hash.get(nums[i]);
                return indexes;
            }
            hash.put(target-nums[i],i);
        }
        return indexes;

    }
}
