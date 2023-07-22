package DSA.RECURSION;

public class BUBBLESORT {
    public static void bubblesort(int[] arr,int i,int j){
        if (i==0){
            return;
        }
        if (j<i){
            if (arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=arr[j];
            }
            bubblesort(arr,i,j+1);
        }
        bubblesort(arr,i-1,0);
    }
    public static void sort(int []arr){
        bubblesort(arr, arr.length -1,0);
    }
}
