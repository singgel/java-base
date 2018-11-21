package com.hks.eightsortingalgorithms.method.search.impl;

import com.hks.eightsortingalgorithms.method.search.BinarySearch;
import org.springframework.stereotype.Service;

/**
 * @Author: hekuangsheng
 * @Date: 2018/11/21
 */
@Service
public class BinarySearchImpl implements BinarySearch {

    @Override
    public int search(int[] intArr, int key) {
        int low = 0;
        int high = intArr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == intArr[middle]) {
                return middle;
            } else if (key < intArr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

}
