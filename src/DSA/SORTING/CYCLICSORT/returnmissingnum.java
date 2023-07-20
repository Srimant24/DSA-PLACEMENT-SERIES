package DSA.SORTING.CYCLICSORT;

import java.util.ArrayList;

public class returnmissingnum {
    static int missing(int[] nums){
        sort(nums);
       for (int i=0;i< nums.length/2;i++){
            int start=i;
            int end= nums.length-1-i;
            if (nums[start]!=start){
                return start;
            }if(nums[end]!=end) {
                return end;
            }
        }
        return -1;
    }
    static int miss(int[] arr){
        sort1(arr);
        int ans=0;
        for (int i =0;i< arr.length;i++){
            if (arr[i]!=i+1){
                ans= i+1;
            }
        }
        return ans;
    }
    static void sort(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i];
            if (arr[i]< arr.length && arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }else {
                i++;
            }
        }
    }
    static void sort1(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i]-1;
            if (arr[i]<arr.length && arr[correct]!=arr[i]){
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
        int[] num={0,1,3};
        int[] nums={1,5,4,3,7,2};
       int nu=missing(num);
       int n=missing(nums);
        System.out.println(nu);
        System.out.println(n);
    }
}
