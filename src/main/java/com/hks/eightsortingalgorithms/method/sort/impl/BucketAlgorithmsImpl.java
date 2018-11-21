package com.hks.eightsortingalgorithms.method.sort.impl;

import com.hks.eightsortingalgorithms.method.sort.BucketAlgorithms;
import org.springframework.stereotype.Service;

@Service
public class BucketAlgorithmsImpl implements BucketAlgorithms {

    @Override
    public int[] sort(int[] intArr) {
        sort(intArr,10);
        return intArr;
    }

    /**
     * 基数排序函数
     * @param arr 表示要排序的数组
     * @param d 表示每一位数字的范围（这里是10进制数，有0~9一共10种情况）
     */
    public static void sort(int[] arr,int d){
        //n用来表示当前排序的是第几位
        int n = 1;
        //hasNum用来表示数组中是否有至少一个数字存在第n位
        boolean hasNum = false;
        //二维数组temp用来保存当前排序的数字
        //第一维d表示一共有d个桶
        //第二维a.length表示每个桶最多可能存放a.length个数字
        int[][] temp = new int[d][arr.length];
        int[] order = new int[d];
        while(true){
            //判断是否所有元素均无比更高位，因为第一遍一定要先排序一次，所以有n!=1的判断
            if(n != 1 && !hasNum){
                break;
            }
            hasNum = false;
            //遍历要排序的数组，将其存入temp数组中（按照第n位上的数字将数字放入桶中）
            for(int i = 0;i < arr.length;i++){
                int x = arr[i]/(n*10);
                if(x != 0){
                    hasNum = true;
                }
                int lsd = (x%10);
                temp[lsd][order[lsd]] = arr[i];
                order[lsd]++;
            }
            //k用来将排序好的temp数组存入data数组（将桶中的数字倒出）
            int k = 0;
            for(int i = 0;i < d;i++){
                if(order[i] != 0){
                    for(int j = 0;j < order[i];j++){
                        arr[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n++;
        }
    }

}