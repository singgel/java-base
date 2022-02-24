package com.hks.eightsortingalgorithms.leetcode;

public class generateMatrix {

    public static void main(String[] args) {
        int[][] aa = generateMatrix(3);
        System.out.println(aa);
    }

    static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upPOS = 0, lowPOS = n - 1;
        int leftPOS = 0, rightPOS = n - 1;
        int res = 1;
        while (res <= n * n) {
            if (upPOS <= lowPOS) {
                for (int i = leftPOS; i <= rightPOS; i++) {
                    matrix[upPOS][i] = res++;
                }
                upPOS++;
            }
            if (rightPOS >= leftPOS) {
                for (int i = upPOS; i <= lowPOS; i++) {
                    matrix[i][rightPOS] = res++;
                }
                rightPOS--;
            }
            if (lowPOS >= upPOS) {
                for (int i = rightPOS; i >= leftPOS; i--) {
                    matrix[lowPOS][i] = res++;
                }
                lowPOS--;
            }
            if (leftPOS <= rightPOS) {
                for (int i = lowPOS; i >= upPOS; i--) {
                    matrix[i][leftPOS] = res++;
                }
                leftPOS++;
            }
        }
        return matrix;
    }
}
