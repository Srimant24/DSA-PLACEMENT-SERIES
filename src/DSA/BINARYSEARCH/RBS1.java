package DSA.BINARYSEARCH;

public class RBS1 {
    static int searchin(int[] nums,int target){
        int peak=RBS(nums);
        int firstsearch=search(nums,0,peak,target);
        if(firstsearch!=-1){
            return firstsearch;
        }else {
            return search(nums,peak+1, nums.length-1,target);
        }
    }
    static int RBS(int[] nums){
        int start=0;
        int end= nums.length-1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            } else if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (nums[start] > nums[start + 1]) {
                    return start;
                } start++;
                 if (nums[end]<nums[end-1]) {
                    return end-1;
                }
                 end--;
            } else if (nums[start]<nums[mid]||nums[start]==nums[mid]&&nums[mid]>nums[end]){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
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
}
