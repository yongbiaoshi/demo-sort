package com.my.demo.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    private static final int LEN = 100;
    private static int[] array = newArray(LEN);
    private static int[] correct;
    private static int from = 0;
    private static int to = 100;

    static {
        print(array);
        correct = copy(array);
        Arrays.sort(correct, from, to);
        print(correct);
        System.out.println("=============");
    }

    public static void main(String[] args) {

        test(copy(array), new SelectionSorter());
        test(copy(array), new BubbleSorter());
        test(copy(array), new InsertionSorter());

    }

    private static void test(int[] array, Sorter sorter) {
        int count = sorter.sort(array, from, to);
        print(array);
        System.out.println(sorter.name() + "-循环次数：" + count);
        // 判断排序结果是否正确
        if (!checkSorted(array)) {
            System.err.println(sorter.name() + "排序失败");
        }
    }

    private static int[] copy(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * 生成随机数组
     *
     * @param len 数组长度
     * @return 数组
     */
    private static int[] newArray(int len) {
        int[] array = new int[len];
        IntStream.range(0, len).forEach(i -> {
            array[i] = RandomUtils.nextInt(0, len * 10);
        });
        return array;
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * 查询排序结果是否正确
     *
     * @param array 数组
     * @return 是否排序成功
     */
    private static boolean checkSorted(int[] array) {
        return Arrays.equals(array, correct);
    }
}
