package com.hks.eightsortingalgorithms.method.search;

/**
 * @Author: hekuangsheng
 * @Date: 2018/11/21
 */
public interface BinarySearch {

    /**
     * 二分查找又称折半查找，它是一种效率较高的查找方法。 【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
     *
     * @param intArr
     *            有序数组 *
     * @param key
     *            查找元素 *
     * @return searchKey的数组下标，没找到返回-1
     */
    int search(int[] intArr, int key);
}
