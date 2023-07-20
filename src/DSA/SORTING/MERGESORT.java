package DSA.SORTING;


import java.util.Arrays;

public class MERGESORT {
    static void mergesort(int[] arr,int p,int q){
        int[] nums=new int[arr.length];
        if (p<q){
            int mid=(p+q)/2;
            mergesort(arr,p,mid);
            mergesort(arr,mid+1,q);
            merge(arr,p,mid,q,nums);
        }
    }
    static void merge(int[] arr,int lb,int mid,int ub,int[] nums){
        int i=lb;
        int j=mid+1;
        int k=lb;
        while (i<=mid&&j<=ub){
            if (arr[i] <= arr[j]){
                nums[k]=arr[i];
                i++;
            }else {
                nums[k]=arr[j];
                j++;
            }
            k++;
        }
        if (i>mid){
            while (j<=ub){
                nums[k]=arr[j];
                j++;
                k++;
            }
        }else{
            while(i<=mid){
                nums[k]=arr[i];
                i++;
                k++;
            }
        }
        for (k=lb;k<=ub;k++){
            arr[k]=nums[k];
        }
    }
    public static void main(String[] args) {
        int[] nums={23,1,4,32,56};
        mergesort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
