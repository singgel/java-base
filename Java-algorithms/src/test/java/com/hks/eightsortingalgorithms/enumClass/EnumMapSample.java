package com.hks.eightsortingalgorithms.enumClass;

import java.util.*;
public class EnumMapSample {
    enum Size {
        Small,
        Medium,
        Large;
    }
    public static void main(String args[]) {
        Map<Size, Double> map = new EnumMap<Size, Double>(Size.class);
        map.put(Size.Small, 0.8);
        map.put(Size.Medium, 1.0);
        map.put(Size.Large, 1.2);
        for (Map.Entry<Size, Double> entry : map.entrySet()) {
            helper(entry);
        }
    }
    private static void helper(Map.Entry<Size, Double> entry) {
        System.out.println("Map entry: " + entry);
    }
}
