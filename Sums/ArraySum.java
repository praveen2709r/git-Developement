package Sums;

import java.util.Arrays;

public class ArraySum {
    public static void rotate(int[] arr,int k){
        int[] temp=new int[arr.length];
        int s=0;
        for(int i=k+1;i<arr.length;i++){
            temp[s++]=arr[i];
        }for(int i=0;i<k;i++){
            temp[s++]=arr[i];
        }
    }
    public static void main(String[] args) {
        int[] arr={-1,-100,3,99};
        int k=3;
        rotate(arr,k);
    }
}
