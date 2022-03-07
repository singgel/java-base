package com.hks.eightsortingalgorithms.leetcode;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) {
            return -1;
        }

        int sumSub = 0;
        int max =  nums[0];
        for (int i = 0; i < nums.length; i++) {
            sumSub = Math.max(sumSub+nums[i], nums[i]);
            max = Math.max(max, sumSub);
        }
        return max;
    }
}
