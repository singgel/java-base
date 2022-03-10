package com.hks.eightsortingalgorithms.leetcode;

import java.util.Arrays;

public class triangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; j++) {
                int left = j+1, right = n-1, k = j;
                while(left < right) {
                    int mid = left + (right - left) / 2;
                    if(nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}
