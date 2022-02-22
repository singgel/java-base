package com.hks.eightsortingalgorithms.leetcode;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(arr);
    }

    static void duplicateZeros(int[] arr) {
        int zeroNum = 0;
        int arrLen = arr.length-1;
        for(int i=0; i<=arrLen-zeroNum; i++) {
            if(arr[i]==0) {
                if(i==arrLen-zeroNum) {
                    arr[arrLen] = 0;
                    arrLen = arrLen-1;
                    break;
                }
                zeroNum++;
            }
        }

        for(int i=arrLen; i>=0; i--) {
            if(arr[i]==0){
                arr[i+zeroNum] = 0;
                zeroNum--;
                arr[i+zeroNum] = 0;
            } else {
                arr[i+zeroNum] = arr[i];
            }
        }
    }
}
