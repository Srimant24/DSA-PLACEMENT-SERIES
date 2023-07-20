package DSA.BINARYSEARCH;

public class ifinitearray {
    static int infinite(int[] nums,int target){
        int start=0;
        int last=1;
        while(target>nums[last]){
            int temp=start;
            last=last+((last-start)+1)*2;
            temp=last+1;
        }
        return search(nums,start,last,target);
    }
    static int search(int[] nums,int start,int last,int target)
    {
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
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,23,34,56,67,89,90,101,102};
        int pos=infinite(arr,14);
        System.out.println(pos);
    }
}
