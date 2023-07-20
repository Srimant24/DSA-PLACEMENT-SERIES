package DSA.SORTING.CYCLICSORT;

import java.util.ArrayList;

public class firstpoistiveinteger {
    static int missingpositive(int[] arr){
        sort(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=i+1){
                //list.add(arr[i]);
                return i+1;
            }
        }
        return arr.length+1;
    }
    static void sort(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i]-1;
            if (arr[i]>0 && arr[i]<= arr.length && arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }else {
                i++;
            }
        }
    }
    static void swap(int[] nums,int f,int l){
        int temp=nums[f];
        nums[f]=nums[l];
        nums[l]=temp;
    }

    public static void main(String[] args) {
        int[] arr={1,3,4,5};
        int li=missingpositive(arr);
        System.out.println(li);
    }
}
