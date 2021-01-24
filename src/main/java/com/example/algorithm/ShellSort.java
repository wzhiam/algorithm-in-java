package com.example.algorithm;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    /**
     * 在用代码实现的时候, 是连续地, 递进地进行插入排序, 不是真正意义上的物理分成多个子序列
     * 当增量是2时, 说明要分成2个子序列进行排序, 如下数组:
     *  array = [1, 2, 3, 7, 5, 8, 4, 9, 6]
     *
     * ++++++ 按照思路上分为(实际还是在同一个数组里):
     *  1组: [1,    3,    5,    4,    6]
     *  2组: [   2,    7,    8,    9   ]
     * 然后再每组进行插入排序:
     *  1组: [1,    3,    4,    5,    6]
     *  2组: [   2,    7,    8,    9   ]
     * 所以排序后数组:
     *  array = [1, 2, 3, 7, 4, 8, 5, 9, 6]
     *
     * ++++++ 编程语言来实现的话, 当增量为2时:
     * 数组: [1, 2, 3, 7, 5, 8, 4, 9, 6]
     * 下标:  0, 1, 2, 3, 4, 5, 6, 7, 8
     *
     * 分 2 组, 从下标为 2 开始, 2 - 增量 = 0, array[2] > array[0], 这边位置不用变
     * 然后下标 + 1 为 3, 3 - 增量 = 1, array[3] > array[1], 这边位置不用变
     * 然后下标 + 1 为 4, 4 - 增量 = 2, array[4] > array[2], 这边位置不用变
     * ...
     *
     * 所以上面用代码实现的时候是连续的进行插入排序,
     */
    public static void main(String[] args) {
        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5};
//        int[] array = {6, 2, 4, 7, 1, 8, 3, 9, 5, 0};
        sort(array);
    }

    public static void sort(int[] array) {
        Assert.checkNull(array);

        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            System.out.println("[增量=" + gap + "] " + Arrays.toString(array));
            for (int i = gap; i < array.length; i++) {
                System.out.println("    for: [i=" + i + "] " + Arrays.toString(array));
                int j = i;
                int currentValue = array[i];
                while (j - gap >= 0 && currentValue < array[j - gap]) {
                    System.out.println("    while: [j=" + j + ", j-gap=" + (j - gap) + "] " + Arrays.toString(array));
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = currentValue;
            }
        }
        System.out.println("结束排序: " + Arrays.toString(array));
    }

}
