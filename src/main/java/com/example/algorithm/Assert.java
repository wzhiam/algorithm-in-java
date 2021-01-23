package com.example.algorithm;

public class Assert {

    public static void checkNull(int[] array) {
        if (array == null) {
            throw new RuntimeException("数组为空值");
        }
    }

}
