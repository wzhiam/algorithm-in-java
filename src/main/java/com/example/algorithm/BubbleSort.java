package com.example.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 无序的数组
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        sort1(array);
        int[] array2 = {6, 2, 4, 7, 1, 8, 3, 9, 5};
        sort2(array2);
    }

    /**
     * 简单实现
     */
    public static void sort1(int[] array) {
        System.out.println(">>>>>>>>>>> sort1() begin:");
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("[" + i + "] " + Arrays.toString(array));
        }
    }

    /**
     * 优化: 方法一中, 当后面几个顺序已经排好了还是会继续对比, 可以让它提前结束
     * 结果: 从输出结果可以看出来方法二比方法一少遍历3次
     */
    public static void sort2(int[] array) {
        System.out.println(">>>>>>>>>>> sort2() begin:");

        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;

                    flag = false;
                }
            }

            // 如果这一轮没有数据变换位置的话, 说明已经全部排序好了
            if (flag) {
                break;
            }
            System.out.println("[" + i + "] " + Arrays.toString(array));
        }
    }

}
