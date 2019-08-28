package com.life.leetCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 冒泡排序
 * @author: qirp
 * @since: 2019/8/28 16:24
 **/
@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        log.info("排序前：{}",arr);
        sort(arr);
        log.info("排序后：{}",arr);
    }

    /**
     * 冒泡排序，就是循环比较相邻两个元素的值
     * 时间复杂度o(n^2)
     * @param arr
     */
    public static void sort(int[] arr){
        int length = arr.length - 1;
        for(int i = 0;i< length;i++){
            for(int j = 0;j< length -i;j++){
                if(arr[j] > arr[j + 1]){
                    //交换两个的值
                    int temp = arr[j];
                    arr[j] = arr[j+ 1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
