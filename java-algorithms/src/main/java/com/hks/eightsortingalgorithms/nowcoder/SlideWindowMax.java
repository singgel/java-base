package com.hks.eightsortingalgorithms.nowcoder;

import java.util.LinkedList;

public class SlideWindowMax {

    public static int[] getMaxWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekFirst()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qmax.pollFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,1,1,1,1,1,5};
        int[] res = getMaxWindow(arr,3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
