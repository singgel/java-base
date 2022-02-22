package com.hks.eightsortingalgorithms.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String ss = reverseWords(s);
        System.out.println(ss);
    }

    public static String reverseWords(String s) {
        int left=0, right=s.length()-1;
        while(left<=right && s.charAt(right)==' ') {
            right--;
        }
        while(left<=right && s.charAt(left)==' ') {
            left++;
        }
        Deque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(left<=right) {
            if(sb.length()!=0 && s.charAt(left)==' ') {
                queue.addFirst(sb.toString());
                sb.setLength(0);
            }
            if(s.charAt(left)!=' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        queue.addFirst(sb.toString());
        return String.join(" ", queue);
        /*int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);*/
    }
}
