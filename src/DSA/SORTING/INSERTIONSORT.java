package DSA.SORTING;

import java.util.Arrays;

public class INSERTIONSORT {
    static void insertion(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if (arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={23,1,4,32,56};
        insertion(nums);
        System.out.println(Arrays.toString(nums));
    }
}
