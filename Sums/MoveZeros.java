package Sums;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr={0,1,0,0,3,-2,11,7,0};
        int i=0;
        int j=1;
        while(j<arr.length){
            if(arr[i]==0&&arr[j]!=0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[j]==0){
                j++;
            }
            else
                i++;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
