package DSA.BINARYSEARCH;

public class lagestsplitarry {
    static int lagestsum(int[] nums,int m) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(0, nums[i]);
            end += nums[i];
        }
        while (start < end) {
            int sum = 0;
            int pieces = 1;
            int mid = start + (end - start) / 2;
            for (int num : nums) {
                if (sum+num>mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum = num;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            } else {
                 end=mid;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        int[] arr={23,45,43,12,67,89,90,32};
        int sum=lagestsum(arr,5);
        System.out.println(sum);
    }
}
