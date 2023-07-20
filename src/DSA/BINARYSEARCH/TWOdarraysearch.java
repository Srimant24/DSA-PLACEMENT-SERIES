package DSA.BINARYSEARCH;

import java.util.Arrays;

public class TWOdarraysearch {
    static int[] search(int[][] nums,int target){
        int r=0;
        int c= nums.length-1;
        while(r< nums.length&&c>=0){
            if (nums[r][c]==target){
                return new int[]{r,c};
            } else if (nums[r][c]>target) {
                c--;
            }else {
                r++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] arr={
                {10,20,30,40},{12,23,34,56},{56,67,78,90}
        };
        int[] pos=search(arr,67);
        System.out.println(Arrays.toString(pos));
    }
}
