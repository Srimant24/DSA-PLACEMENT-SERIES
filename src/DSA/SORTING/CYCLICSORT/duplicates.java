package DSA.SORTING.CYCLICSORT;

public class duplicates {
    static int sort(int[] arr){
        int i=0;
        while (i< arr.length){
            if (arr[i]!=i+1){
                int correct=arr[i]-1;
                if (arr[correct]!=arr[i]){
                    swap(arr,correct,i);
                }else {
                    return arr[i];
                }
            }else {
                i++;
            }
        }
        return -1;
    }
    static void swap(int[] nums,int f,int l){
        int temp=nums[f];
        nums[f]=nums[l];
        nums[l]=temp;
    }

    public static void main(String[] args) {

    }
}
