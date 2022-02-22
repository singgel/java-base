package com.hks.eightsortingalgorithms.leetcode;

public class sortColors {

    public static void main(String[] args) {
        int[] ii = new int[]{2,0,2,1,1,0};
    }

    public static void sortColors(int[] nums) {
        int left=0, right=nums.length-1;
        for(int i=0; i<=right; i++) {
            if(nums[i]==0) {
                swap(nums, left, i);
                left++;
            }
            if(nums[i]==2) {
                swap(nums, right, i);
                right--;
                i--;
            }
        }
    }

    static void swap(int[] nums, int l, int r) {
        int tep = nums[l];
        nums[l] = nums[r];
        nums[r] = tep;
    }
}
