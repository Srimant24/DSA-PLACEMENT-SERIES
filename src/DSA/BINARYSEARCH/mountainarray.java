package DSA.BINARYSEARCH;

public class mountainarray {
    static int search(int[] nums){
        int start=0;
        int last= nums.length-1;
        while (start<last){
            int mid=start+(last-start)/2;
            if (nums[mid]>nums[mid+1]){
                last=mid;
            } else{
                start=mid+1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,5,4,3,2,1};
        int pos=search(arr);
        System.out.println(pos);
    }
}
