package DSA.SORTING;

import java.util.Arrays;

public class BUBBLESORT {
    static void bubble(int[] arr){
        for (int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-i;j++){
                if (arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={1,0,0,6,5};
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
}
