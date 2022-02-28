package com.hks.eightsortingalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class subsets {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
