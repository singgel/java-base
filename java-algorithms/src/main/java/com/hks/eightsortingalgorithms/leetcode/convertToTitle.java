package com.hks.eightsortingalgorithms.leetcode;

public class convertToTitle {

    public static void main(String[] args) {
        String s = convertToTitle(77);
        System.out.println(s);
    }

    public static String convertToTitle(int cn) {
        StringBuilder sb = new StringBuilder();
        while(cn>0) {
            cn--;
            sb.append((char)(cn%26 + 'A'));
            cn = cn /26;
        }
        sb.reverse();
        return  sb.toString();
    }
}
