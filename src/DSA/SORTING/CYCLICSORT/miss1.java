package DSA.SORTING.CYCLICSORT;

import java.util.ArrayList;

public class miss1 {
    static ArrayList miss(int[] arr){
        sort(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i< arr.length;i++){
           if (arr[i]!=i+1){
               //list.add(arr[i]);
               list.add(i+1);
           }
        }
        return list;
    }
    static ArrayList miss1(int[] arr){
        sort1(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=i){
                list.add(arr[i]);
                list.add(i);
            }
        }
        return list;
    }

    static void sort(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i]-1;
            if (arr[i]>0 && arr[i]<arr.length && arr[correct]!=arr[i]){
                swap(arr,i,correct);
            }else {
                i++;
            }
        }
    }
    static void sort1(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i];
            if ( arr[correct]!=arr[i]){
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
        int[] nums={0,2,1};
        int[]num1={0,1,2,3,3,4,5,7,8};
        ArrayList<Integer>li=new ArrayList<>();
        ArrayList<Integer>lis=new ArrayList<>();
        //lis=miss1(num1);
        li=miss(nums);
        System.out.println(li);
       // System.out.println(lis);
    }
}
