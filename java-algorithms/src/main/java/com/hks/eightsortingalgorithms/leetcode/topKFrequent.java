package com.hks.eightsortingalgorithms.leetcode;

import javafx.util.Pair;

import java.util.*;

public class topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //先按出现频率升序排序, 再按照字母字典序排序
        PriorityQueue<Pair<String, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue().equals(o1.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(new Pair<>(entry.getKey(), entry.getValue()));
            if (queue.size() > k){
                queue.poll();
            }
        }
        LinkedList<String> ans = new LinkedList<>();
        while (!queue.isEmpty()){
            ans.addFirst(queue.poll().getKey());
        }
        return ans;
    }
}
