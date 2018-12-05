package com.my.demo.sort;

/**
 * 排序
 */
public interface Sorter {

    /**
     * 排序算法的名字
     *
     * @return 名字
     */
    String name();

    /**
     * 数组排序
     *
     * @param array 数组
     * @return 循环次数
     */
    default int sort(int[] array) {
        return sort(array, 0, array.length);
    }

    /**
     * 数组排序
     *
     * @param array     数组
     * @param fromIndex 开始下标
     * @param toIndex   结束下标
     * @return 循环次数
     */
    int sort(int[] array, int fromIndex, int toIndex);

}
