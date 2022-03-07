package com.hks.eightsortingalgorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        //排序
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> resultarr = new ArrayList<>();
        //存入哈希表
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Integer t;
        int target = 0;
        for(int i=0; i<nums.length; i++) {
            target = -nums[i];
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<nums.length; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) {
                    continue;
                }
                if((t=map.get(target-nums[j]))!=null) {
                    if(t>j){
                        resultarr.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[t])));
                    } else {
                        break;
                    }
                }
            }
        }
        /*for (int i = 0; i < nums.length; ++i) {
            target = -nums[i];
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((t = map.get(target - nums[j])) != null) {
                    //符合要求的情况,存入
                    if (t > j) {
                        resultarr.add(new ArrayList<>
                                (Arrays.asList(nums[i], nums[j], nums[t])));

                    } else {
                        break;
                    }
                }
            }
        }*/

        return resultarr;
    }
}
