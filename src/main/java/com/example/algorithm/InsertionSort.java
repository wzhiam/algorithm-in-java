package com.example.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        sort(array);
    }

    public static void sort(int[] array) {
        System.out.println(">>>>>>>>>>> sort() begin:");
        Assert.checkNull(array);

        int preIndex;
        int currentValue;
        for (int i = 1; i < array.length; i++) {
            preIndex = i - 1;
            // 先将要插入的数提取出来, 用于和其他数单独比较
            currentValue = array[i];
            // 这里加一个判断, 只有比上一个数小的时候, 将上一个数放到当前位置,
            while (preIndex >= 0 && array[preIndex] > currentValue) {
                System.out.println("--------");
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = currentValue;
            System.out.println("[" + i + "] " + Arrays.toString(array));
        }
    }

}
