package com.hks.eightsortingalgorithms.method.sort.impl;

import com.hks.eightsortingalgorithms.method.sort.StraightInsertAlgorithms;
import org.springframework.stereotype.Service;

@Service
public class StraightInsertAlgorithmsImpl implements StraightInsertAlgorithms {

    @Override
    public int[] sort(int[] args) {
        int tmp;
        for (int i = 1; i < args.length; i++) {
            for (int j = i; j > 0; j--) {
                if (args[j] < args[j - 1]) {
                    tmp = args[j - 1];
                    args[j - 1] = args[j];
                    args[j] = tmp;
                }
            }
        }
        return args;
    }

}
