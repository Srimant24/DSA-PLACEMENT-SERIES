package DSA.SORTING.CYCLICSORT;

import java.util.ArrayList;

public class duplicates1andmissandsetmismatch {
    static ArrayList dupli(int[] arr){
        sort(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=i+1){
                list.add(arr[i]);
                //list.add(i+1);
            }
        }
        return list;
    }
    static ArrayList mismatch(int[] arr){
        sort(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=i+1){
                list.add(arr[i]);
                list.add(i+1);
            }
        }
        return list;
    }
    static ArrayList miss(int[] arr){
        sort(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=0;i< arr.length;i++){
            if (arr[i]!=i+1){
               // list.add(arr[i]);
                list.add(i+1);
            }
        }
        return list;
    }
    static void sort(int[] arr){
        int i=0;
        while (i< arr.length){
            int correct=arr[i]-1;
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
        int[] num={1,2,3,4,3,5,6};
        int[] nums={1,2,3,3,5,6};
        int[] num1={1,2,2,4};
        ArrayList<Integer>list=new ArrayList<>();
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        list=dupli(num);
        list1=mismatch(num1);
        list1=miss(nums);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);
    }
}
