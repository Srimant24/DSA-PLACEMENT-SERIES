package DSA.BINARYSEARCH;

import java.util.Arrays;

public class firstandlastoccurance {
    static int[] pos(int[] nums,int target){
       int[] ans ={-1,-1};
       int first=search(nums,target,true);
       int last=search(nums,target,false);
       ans[0]=first;
       ans[1]=last;
       return ans;
    }
    static int search(int[] nums,int target,boolean firstoccurance){
        int ans=-1;
        int start=0;
        int last= nums.length-1;
        while (start<=last){
            int mid=start+(last-start)/2;
            if (target==nums[mid]){
                ans=mid;
                if (firstoccurance){
                    last=mid-1;
                }else{
                    start=mid+1;
                }
            } else if (target<nums[mid]) {
                last=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,4,4,5,6,7};
        int[] position=pos(arr,4);
        System.out.println(Arrays.toString(position));
    }
}
