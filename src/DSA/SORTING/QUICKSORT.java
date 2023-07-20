package DSA.SORTING;

import java.util.Arrays;

public class QUICKSORT {
    static void quicksort(int[] arr,int p,int q){
        if (p<q){
            int pos=quickpartion(arr,p,q);
            quicksort(arr,p,pos-1);
            quicksort(arr,pos+1,q);
        }
    }
    static int quickpartion(int[] arr,int p,int q){
        int key=arr[p];
        int i=p;
        for (int j=p+1;j<=q;j++){
            if (arr[j]<=key){
                i=i+1;
                swap(arr,i,j);
            }
        }
        swap(arr,p,i);
        return i;
    }
    static void swap(int[] nums,int f,int l){
        int temp=nums[f];
        nums[f]=nums[l];
        nums[l]=temp;
    }
    public static void main(String[] args) {
        int[] nums={23,1,4,32,56};
        quicksort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
