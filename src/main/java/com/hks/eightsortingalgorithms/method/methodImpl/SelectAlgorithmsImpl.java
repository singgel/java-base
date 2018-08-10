package com.hks.eightsortingalgorithms.method.methodImpl;

import com.hks.eightsortingalgorithms.method.SelectAlgorithms;
import org.springframework.stereotype.Component;

@Component
public class SelectAlgorithmsImpl implements SelectAlgorithms {

    private static void exchang(int[] s, int i, int j) {
        int temp = s[j];
        s[j] = s[i];
        s[i] = temp;
    }

    @Override
    public int[] sort(int[] intArr) {
        int temp;
        for (int i = 0; i < intArr.length - 1; i++) {
            temp = i;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[temp] > intArr[j]) {
                    temp = j;
                }
            }
            if (temp != i) {
                exchang(intArr, i, temp);
            }
        }
        return intArr;
    }
}
