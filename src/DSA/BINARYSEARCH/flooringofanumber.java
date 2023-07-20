package DSA.BINARYSEARCH;

import java.lang.reflect.GenericDeclaration;

public class flooringofanumber {
    static int search(int[] nums,int target){
        int start=0;
        int last= nums.length-1;
        while (start<=last){
            int mid=start+(last-start)/2;
            if (target==nums[mid]){
                return mid;
            } else if (target<nums[mid]) {
                last=mid-1;
            }else{
                start=mid+1;
            }
        }
        return last;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,5,6,7};
        int pos=search(arr,4);
        System.out.println(pos);
    }
}
