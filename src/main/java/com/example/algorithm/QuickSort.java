package com.example.algorithm;

import java.util.Arrays;

/**
 * 快速排序, 也是使用的分治法
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序
     */
    public static void quickSort(int array[], int left, int right)
    {
        if (left < right)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = left, j = right, x = array[left];
            while (i < j)
            {
                while(i < j && array[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j) {
                    array[i++] = array[j];
                }

                while(i < j && array[i] < x) // 从左向右找第一个大于等于x的数
                    i++;

                if (i < j) {
                    array[j--] = array[i];
                }
            }
            array[i] = x;
            quickSort(array, left, i - 1); // 递归调用
            quickSort(array, i + 1, right);
        }
    }

}
