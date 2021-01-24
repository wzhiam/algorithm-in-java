package com.example.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        mergeSort1(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort1(int[] array, int low, int high) {
        if (low < high) {
            int mid = (high - low) / 2;
            mergeSort1(array, low, mid);
            mergeSort1(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int tempIndex = 0;
        int left = low, right = mid + 1;
        while (left < mid && right < high) {
            temp[tempIndex++] = array[left] < array[right] ? array[left++] : array[right++];
        }

        while (left < mid) {
            temp[tempIndex++] = array[left++];
        }
        while (right < high) {
            temp[tempIndex++] = array[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            // 注意这里赋值给 array 数组的下标起点
            array[low + i] = temp[i];
        }
    }

}
