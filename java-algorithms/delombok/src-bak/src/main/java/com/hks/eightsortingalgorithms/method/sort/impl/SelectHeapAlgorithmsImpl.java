package com.hks.eightsortingalgorithms.method.sort.impl;

import com.hks.eightsortingalgorithms.method.sort.SelectHeapAlgorithms;
import org.springframework.stereotype.Component;

@Component
public class SelectHeapAlgorithmsImpl implements SelectHeapAlgorithms {

    // 构建堆
    public static void buildMaxHeap(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }

        // 堆的公式就是 int root = 2*i, int left = 2*i+1, int right = 2*i+2;
        int cursor = array.length / 2;
        // 这样for循环下，就可以第一次排序完成
        for (int i = cursor; i >= 0; i--) {
//            maxHeap(array, array.length, i);
            minHeap(array, array.length, i);
        }
    }

    // 最大堆
    public static void maxHeap(int[] array, int heapSieze, int index) {
        // 左子节点
        int left = index * 2 + 1;
        // 右子节点
        int right = index * 2 + 2;
        // 暂时定在Index的位置就是最大值
        int maxValue = index;

        // 如果左子节点的值，比当前最大的值大，就把最大值的位置换成左子节点的位置
        if (left < heapSieze && array[left] > array[maxValue]) {
            maxValue = left;
        }

        // 如果右子节点的值，比当前最大的值大，就把最大值的位置换成右子节点的位置
        if (right < heapSieze && array[right] > array[maxValue]) {
            maxValue = right;
        }

        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (maxValue != index) {
            // 就要交换位置元素
            swap(array, index, maxValue);

            // 交换完位置后还需要判断子节点是否打破了最大堆的性质。最大堆性质：两个子节点都比父节点小。
            maxHeap(array, heapSieze, maxValue);
        }
    }

    // 最小堆
    public static void minHeap(int[] array, int heapSieze, int index) {
        // 左子节点
        int left = index * 2 + 1;
        // 右子节点
        int right = index * 2 + 2;
        // 暂时定在Index的位置就是最小值
        int maxValue = index;

        // 如果左子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (left < heapSieze && array[left] < array[maxValue]) {
            maxValue = left;
        }

        //  如果右子节点的值，比当前最小的值小，就把最小值的位置换成左子节点的位置
        if (right < heapSieze && array[right] < array[maxValue]) {
            maxValue = right;
        }

        // 如果不相等，说明啊，这个子节点的值有比自己小的，位置发生了交换了位置
        if (maxValue != index) {
            // 就要交换位置元素
            swap(array, index, maxValue);

            // 交换完位置后还需要判断子节点是否打破了最小堆的性质。最小性质：两个子节点都比父节点大。
            minHeap(array, heapSieze, maxValue);
        }
    }

    // 数组元素交换
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Override
    public int[] sort(int[] intArr) {
        if (intArr == null || intArr.length == 1) {
            return new int[0];
        }
        // 第一次排序，构建最大堆，只保证了堆顶元素是数组里最大的
        buildMaxHeap(intArr);

        for (int i = intArr.length - 1; i >= 1; i--) {
            // 这个是什么意思呢？，经过上面的一些列操作，目前array[0]是当前数组里最大的元素，需要和末尾的元素交换
            // 然后，拿出最大的元素
            swap(intArr, 0, i);

            // 交换完后，下次遍历的时候，就应该跳过最后一个元素，也就是最大的那个值，然后开始重新构建最大堆
            // 堆的大小就减去1，然后从0的位置开始最大堆
//            maxHeap(array, i, 0);
            minHeap(intArr, i, 0);
        }
        return intArr;
    }

}
