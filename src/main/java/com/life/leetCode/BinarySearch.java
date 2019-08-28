package com.life.leetCode;

/**
 * @author: qirp
 * @since: 2019/8/28 11:25
 **/
public class BinarySearch {

    /**
     * 利用递归的方式查找
     * @param arr
     * @param key
     * @param low
     * @param high
     * @return
     */
    public Integer binarySearch(int[] arr,int key,int low,int high){
        if(key < arr[low] || key > arr[high] || low > high){
            return null;
        }
        //中间位置
        int mid = (low + high)/2;
        if(arr[mid] > key){
            return binarySearch(arr,key,low,mid);
        }else if(arr[mid] > key){
            return binarySearch(arr,key,mid,high);
        }else{
            return arr[mid];
        }
    }

    /**
     * 利用循环查找
     * @param arr
     * @param key
     * @return
     */
    public Integer binarySearch(int[] arr,int key){
        int mid = 0;
        int low = 0;
        int high = arr.length - 1;
        if(key < arr[low] || key > arr[high] || low > high){
            return null;
        }
        while (low <= high){
            mid = (low + high)/2;
            if(arr[mid] < key){
                high = mid - 1;
            }else if(arr[mid] > key){
                low = mid + 1;
            }else{
                return arr[mid];
            }
        }
        return null;
    }
}
