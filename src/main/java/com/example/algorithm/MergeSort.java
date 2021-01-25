package com.example.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 递归处理:
     * 递归的归并排序需要深度为 LogN 的栈空间，虽然代码很简单易懂，但是会造成时间和空间上的性能损耗
     */
    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            // 优化1: 在归并前判断一下，如果左边的最大的比右边的最小的还小(或者等于)，那就不用归并了，已经有序了。
            if (array[mid] <= array[mid + 1]) {
                return;
            }
            merge(array, low, mid, high);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int tempIndex = 0;
        while (left <= mid && right <= high) {
            temp[tempIndex++] = array[left] < array[right] ? array[left++] : array[right++];
        }

        while (left <= mid) {
            temp[tempIndex++] = array[left++];
        }
        while (right <= high) {
            temp[tempIndex++] = array[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            // 注意这里赋值给 array 数组的下标起点
            array[low + i] = temp[i];
        }
    }

    /**
     * 为了优化归并排序，我们可以使用迭代代替递归
     */
    public static void mergeSort2(int[] array, int low, int high) {
        if (low == high) {
            return;
        }

        int mid = (low + high) / 2;
        while (low < high) {

        }
    }

}
