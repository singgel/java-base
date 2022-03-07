package com.hks.eightsortingalgorithms.leetcode;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int res=0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i]-min);
        }
        return res;
    }
}
