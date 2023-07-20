package DSA.BINARYSEARCH;

public class rotation {
    static int countrotation(int[] nums){
        int pivot=RBS(nums);
        return pivot+1;
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
        int noofratation=countrotation(arr);
        System.out.println(noofratation);
    }
}
