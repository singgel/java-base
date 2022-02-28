package com.hks.eightsortingalgorithms.leetcode;

public class uniquePaths {
    public int uniquePaths(int m, int n) {
        return dp(m - 1, n - 1);
    }

    // 定义：从 (0, 0) 到 (x, y) 有 dp(x, y) 条路径
    int dp(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        if (x < 0 || y < 0) {
            return 0;
        }
        return dp(x - 1, y) + dp(x, y - 1);
    }

}
