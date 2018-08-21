package com.hks.eightsortingalgorithms.method.impl;

import com.hks.eightsortingalgorithms.method.QuickAlgorithms;
import org.springframework.stereotype.Service;

@Service
public class QuickAlgorithmsImpl implements QuickAlgorithms {

    @Override
    public int[] sort(int[] intArr) {
        quickSort(intArr, 0, intArr.length - 1);
        return intArr;
    }

    private static void quickSort(int[] arr, int begin, int end) {
        int tbegin = begin, tend = end;
        // 将第一个值作为快排序的分界值
        int pivot = arr[begin];
        while (tbegin < tend) {
            // 如果两个游标没有交集，或者后面一直大于或等于分界值就一直向前移动
            while (tbegin < tend && arr[tend] >= pivot) {
                --tend;
            }
            arr[tbegin] = arr[tend];
            // 如果两个游标没有交集，或者前面是小于或等于分界值，就一直向后头移动
            while (tbegin < tend && arr[tbegin] <= pivot) {
                ++tbegin;
            }
            arr[tend] = arr[tbegin];

        }
        // 将临界值赋值给游标的交集的地方
        arr[tbegin] = pivot;
        if (begin < tend) {
            // 递归排序游标的左边
            quickSort(arr, begin, tend - 1);
        }
        if (tbegin < end) {
            // 递归排序游标的右边
            quickSort(arr, tbegin + 1, end);
        }

    }

}
