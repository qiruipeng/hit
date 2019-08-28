package com.life.leetCode;

import lombok.extern.slf4j.Slf4j;

/**
 * 插入排序
 * @author: qirp
 * @since: 2019/8/28 16:41
 **/
@Slf4j
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        log.info("排序前：{}",arr);
        sort(arr);
        log.info("排序后：{}",arr);
    }

    /**
     * 插入排序，选择一个基准数据，循环插入到合适的位置
     * @param arr
     */
    public static void sort(int[] arr){

        for(int i= 1;i< arr.length;i++){
            int j = i -1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }

    }
}
