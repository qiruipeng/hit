package com.life.leetCode;

/**
 * 分治思想
 *   设X[0:n-1]和Y[0:n-1]为两个数组，每个数组中含有n个已排好序的数，试设计一个O(logn)时间的算法，
 * 找出X和Y的2n个数的中位数，并证明算法的时间复杂性为O(logn)。
 * @author: qirp
 * @since: 2019/8/26 10:48
 **/
public class middle_select {
    public static void main(String[] args) {
        int[] X ={1,3,5,7,9,11,13,15,17,19};
        int[] Y ={2,4,6,8,10,12,14,16,18,20};
        int mid = select(X,Y,0,X.length,0,Y.length);
        System.out.println(mid);
    }

    static int select(int[] X, int[] Y, int x_low, int x_high, int y_low, int y_high){
        if(x_low == x_high){
            return X[x_low];
        }else if(y_low == y_high){
            return Y[y_low];
        }

        int x_mid,y_mid;
        x_mid = (x_low + x_high)/2;
        y_mid = (y_low + y_high)/2;

        if(X[x_mid] > Y[y_mid]){
            x_high = x_mid;
            y_low = y_mid;
        }else if(X[x_mid] < Y[y_mid]){
            x_low = x_mid;
            y_high = y_mid;
        }else {
            return X[x_mid];
        }
        return select(X,Y,x_low,x_high,y_low,y_high);
    }
}
