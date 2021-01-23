package com.example.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        sort(array);
    }

    public static void sort(int[] array) {
        Assert.checkNull(array);

        int temp;
        int index;
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {  // 寻找最小值, 并记录下标
                    index = j;
                }
            }

            if (index != i) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            System.out.println("[" + i + "] " + Arrays.toString(array));
        }
    }

}
