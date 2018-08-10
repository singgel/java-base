package com.hks.eightsortingalgorithms.method.impl;

import com.hks.eightsortingalgorithms.method.ShellAlgorithms;
import org.springframework.stereotype.Service;

@Service
public class ShellAlgorithmsImpl implements ShellAlgorithms {

    @Override
    public int[] sort(int[] args) {
        // 计算出最大的h值
        int h = 1;
        while (h <= args.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = h; i < args.length; i += h) {
                if (args[i] < args[i - h]) {
                    int tmp = args[i];
                    int j = i - h;
                    while (j >= 0 && args[j] > tmp) {
                        args[j + h] = args[j];
                        j -= h;
                    }
                    args[j + h] = tmp;
                }
            }
            // 计算出下一个h值
            h = (h - 1) / 3;
        }
        return args;
    }

}
