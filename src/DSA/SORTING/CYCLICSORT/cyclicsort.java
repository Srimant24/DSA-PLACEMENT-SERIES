package DSA.SORTING.CYCLICSORT;

import java.util.Arrays;

public class cyclicsort {
    static void sort(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i]-1;
            if (arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }else {
                i++;
            }
        }
    }
    static void swap(int[] nums,int f,int l){
        int temp=nums[f];
        nums[f]=nums[l];
        nums[l]=temp;
    }
    public static void main(String[] args) {
        int[] nums={1,3,4,2,5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
