package com.my.demo.sort;

public class ShellSorter implements Sorter {
    @Override
    public String name() {
        return "希尔排序";
    }

    @Override
    public int sort(int[] array, int fromIndex, int toIndex) {

        int len = toIndex - fromIndex;
        int gap = 1;
        while (gap < len / 3) {
            gap = gap * 3 + 1; // 动态定义间隔
        }

        int count = 0;
        for (; gap > 0; gap = gap / 3) {
            for (int i = fromIndex + gap; i < toIndex; i++) {
                int current = array[i];
                for (int j = i - gap; j >= fromIndex; j -= gap) {
                    count++;
                    if (array[j] < current) {
                        array[j + gap] = current;
                        break;
                    } else {
                        array[j + gap] = array[j];
                        if (j - fromIndex <= gap) {
                            array[j] = current;
                        }
                    }
                }
            }
        }

        return count;
    }

}
