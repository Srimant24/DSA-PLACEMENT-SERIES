package DSA.BINARYSEARCH;

public class searchinrotatedsortedarray {
    static int search(int[] nums,int target){
        int peak=RBS(nums);
        int occure=search(nums,0,peak,target);
        if (occure!=-1){
            return occure;
        }
        return search(nums,peak+1, nums.length-1,target);
    }
    static int search(int[] nums,int start,int last,int target){
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

    static int RBS(int[] nums){
        int start=0;
        int end= nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if (mid<end && nums[mid]>nums[mid+1]){
                return mid;
            } else if (mid>start && nums[mid]<nums[mid-1]) {
                return mid-1;
            } else if (nums[start]>mid) {
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,8,9,0,1,2};
        int pos=search(arr,0);
        System.out.println(pos);
    }
}
