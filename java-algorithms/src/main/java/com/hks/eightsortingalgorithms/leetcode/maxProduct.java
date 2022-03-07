package com.hks.eightsortingalgorithms.leetcode;

public class maxProduct {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) {
            return 0;
        }
        int len = nums.length;
        int res = nums[0];

        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.min(Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);

            if(dp[i][1]>res) {
                res = dp[i][1];
            }
        }
        return res;
    }
}
