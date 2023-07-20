package DSA.SORTING;

import java.util.Arrays;

public class SELECTIONSORT {
     static void selection(int[] nums) {
         for (int i=0;i< nums.length;i++){
             int end= nums.length-i-1;
             int max=getmaxindex(nums,end);
             swap(nums,max,end);
         }
    }

     static int getmaxindex(int[] nums,int last) {
         int max=nums[0];
         int index=0;
         for (int i=0;i<=last;i++){
             if (nums[i]>max){
                 index=i;
             }
         }
         return index;
    }
    static void swap(int[]nums,int first,int last){
         int temp=nums[first];
         nums[first]=nums[last];
         nums[last]=temp;
    }

    public static void main(String[] args) {
        int[] nums={23,1,4,32,56};
        selection(nums);
        System.out.println(Arrays.toString(nums));
    }
}
