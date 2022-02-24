package com.hks.eightsortingalgorithms.leetcode;

public class longestPalindrome {

    String palinerome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public String longestPalindrome(String s) {
        String res = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String s1 = palinerome(s, i, i);
            String s2 = palinerome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return  res;
    }

}
