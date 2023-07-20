package DSA.RECURSION;

public class ARRAYSORTEDORNOT {
    public static boolean checkIfIncreasing(int arr[], int idx) {

        if(idx == arr.length-1) {
            return true;
        }
        if(!checkIfIncreasing(arr, idx+1)) {
            return false;
        }
        return arr[idx] < arr[idx + 1];
    }
}
