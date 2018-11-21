package com.hks.eightsortingalgorithms.method.sort.impl;

import com.hks.eightsortingalgorithms.method.sort.BubbleAlgorithms;
import org.springframework.stereotype.Service;

@Service
public class BubbleAlgorithmsImpl implements BubbleAlgorithms {

    @Override
    public int[] sort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = 0; j < intArr.length - 1 - i; j++) {
                if (intArr[j] > intArr[j + 1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = temp;
                }
            }
        }
        return intArr;
    }

}
