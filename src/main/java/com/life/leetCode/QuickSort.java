package com.life.leetCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 快速排序
 * @author: qirp
 * @since: 2019/8/28 14:34
 **/
@Slf4j
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        log.info("排序前：{}",arr);
        sort(arr,0,arr.length -1);
        log.info("排序后：{}",arr);
    }

    /**
     * 快速排序算法
     * 时间复杂度o(nlogn)
     * @param arr
     * @param low
     * @param high
     */
    public static void sort(int[] arr, int low, int high) {
        int l, h, index;
        if (low > high) {
            return;
        }
        l = low;
        h = high;
        index = arr[l]; // 用子表的第一个记录做基准
        while (l < h) { // 从表的两端交替向中间扫描
            while (l < h && arr[h] >= index)
                h--;
            if (l < h)
                arr[l++] = arr[h];// 用比基准小的记录替换低位记录
            while (l < h && arr[l] < index)
                l++;
            if (l < h) // 用比基准大的记录替换高位记录
                arr[h--] = arr[l];
        }
        arr[l] = index;// 将基准数值替换回 a[l]
        sort(arr, low, l - 1); // 对低子表进行递归排序
        sort(arr, l + 1, high); // 对高子表进行递归排序
    }
}
