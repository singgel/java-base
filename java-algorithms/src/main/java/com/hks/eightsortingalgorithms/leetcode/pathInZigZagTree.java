package com.hks.eightsortingalgorithms.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> path = new ArrayList<>();
        while (label >= 1) {
            path.add(label);
            label = label / 2;

            int depth = log(label);
            int[] range = getLevelRange(depth);
            // 由于之字形分布，根据上层的节点取值范围，修正父节点
            label = range[1] - (label - range[0]);
        }
        // 反转成从根节点到目标节点的路径
        Collections.reverse(path);
        return path;
    }

    // 获取第 n 层节点的取值范围
    private int[] getLevelRange(int n) {
        int p = (int) Math.pow(2, n);
        return new int[]{p, 2 * p - 1};
    }

    int log(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
