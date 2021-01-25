package com.example.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        // 递归实现
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        mergeSort(array, 0, array.length - 1);
        System.out.println(">>>>>>>>>> 递归: " + Arrays.toString(array));

        // 优化的方法
        int[] array2 = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        MergeSort2(array2);
        System.out.println(">>>>>>>>>> 迭代优化: " + Arrays.toString(array2));
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
    public static void MergeSort2(int[] arr) {
        //使用非递归的方式来实现归并排序
        int len = arr.length;
        int k = 1;

        while (k < len) {
            MergePass(arr, k, len);
            k *= 2;
        }
    }

    /**
     * MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
     *
     * low: i 从 0 到 2, 4, 6, 8... 不断扩大归并的子序列大小
     * high: i + k - 1 和 i 的差距从 0, 1, 3, 7,
     */
    private static void MergePass(int[] arr, int k, int len) {
        int i = 0;
        //从前往后,将2个长度为k的子序列合并为1个
        while (i < len - 2 * k + 1) {
            System.out.println("k=" + k + ", n=" + len + "     |     i=" + i + ", i+k-1=" + (i + k - 1) + ", i + 2*k - 1=" + (i + 2 * k - 1) + "     |     i += 2 * k=" + (i + 2 * k) + ",  n - 2 * k + 1=" + (len - 2 * k + 1));
            merge(arr, i, i + k - 1, i + 2 * k - 1);
            i += 2 * k;
        }

        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if (i < len - k) {
            System.out.println("落单: k=" + k + ", n=" + len + "     |     i=" + i + ", i+k-1=" + (i + k - 1) + ", n-1=" + (len - 1));
            merge(arr, i, i + k - 1, len - 1);
        }

    }

}
