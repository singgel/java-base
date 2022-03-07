package com.hks.eightsortingalgorithms.leetcode;

public class myAtoi {
    public static void main(String[] args) {
        myAtoi(" ");
    }

    public static int myAtoi(String s) {
        int sin = 1, left = 0, res = 0,len = s.length();
        if(s==null||len==0) {
            return 0;
        }
        while(left<len&&s.charAt(left)==' ') {
            left++;
        }
        if(left==len) {
            return 0;
        }

        if(s.charAt(left)=='+' || s.charAt(left)=='-') {
            sin = s.charAt(left)=='+'? sin : -1;
            left++;
        }

        while(left<len && s.charAt(left) >= '0' && s.charAt(left) <='9') {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && s.charAt(left)>'7')) {
                return sin==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res*10 + (s.charAt(left) - '0');
            left ++;
        }

        return res * sin;
    }
}
