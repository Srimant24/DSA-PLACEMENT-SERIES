package DSA.BINARYSEARCH;

public class searchinmountainarray {
    static int searchin(int[] nums,int target){
        int peak=search(nums,target);
        int firstsearch=search(nums,0,peak,target);
        if(firstsearch!=-1){
            return firstsearch;
        }else {
            return search1(nums,peak+1, nums.length-1,target);
        }
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
    static int search1(int[] nums,int start,int last,int target){
        while (start<=last){
            int mid=start+(last-start)/2;
            if (target==nums[mid]){
                return mid;
            } else if (target<nums[mid]) {
                start=mid=1;
            }else{
                last=mid-1;
            }
        }
        return -1;
    }
    static int search(int[] nums,int target){
        int start=0;
        int last= nums.length-1;
        while (start<last) {
            int mid = start + (last - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                last = mid;
            } else {
                start = mid + 1;
            }
        }
        return last;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,5,4,3,2,1};
        int pos=searchin(arr,5);
        System.out.println(pos);
    }
}
