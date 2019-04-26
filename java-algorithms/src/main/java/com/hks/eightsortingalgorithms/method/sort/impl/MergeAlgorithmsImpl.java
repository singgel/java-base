package com.hks.eightsortingalgorithms.method.sort.impl;

import com.hks.eightsortingalgorithms.method.sort.MergeAlgorithms;
import org.springframework.stereotype.Service;

@Service
public class MergeAlgorithmsImpl implements MergeAlgorithms {

    @Override
    public int[] sort(int[] intArr) {
        mergeSort(intArr, 0, intArr.length - 1);
        return intArr;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(arr, low, mid);
            // 右边
            mergeSort(arr, mid + 1, high);
            // 左右归并
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        // 左指针
        int i = low;
        // 右指针
        int j = mid + 1;
        //数组当前要填数的位置
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // 把新数组中的数覆盖arr数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
    }

}
