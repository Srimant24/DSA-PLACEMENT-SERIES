package DSA.ARRAY;
import java.util.*;
public class MAXIMUMPRODUCTSUBARRAY {
    static int maxProductSubArray(int arr[]) {
        int result = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            int p = arr[i];
            for(int j=i+1;j<arr.length;j++) {
                result = Math.max(result,p);
                p *= arr[j];
            }
            result = Math.max(result,p);
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArray(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }
}
class MAXIMUMPRODUCTSUBARRAYBETTER
{
    static int maxProductSubArray(int arr[]) {
        int maxLeft = arr[0];
        int maxRight = arr[0];

        boolean zeroPresent = false;

        int prod = 1;

        for(int i:arr) {
            prod *= i;
            if(i == 0) {
                zeroPresent = true;
                prod = 1;
                continue;
            }
            maxLeft = Math.max(maxLeft,prod);
        }

        prod = 1;

        for(int j=arr.length-1;j>=0;j--) {
            prod *= arr[j];
            if(arr[j] == 0) {
                zeroPresent = true;
                prod = 1;
                continue;
            }
            maxRight = Math.max(maxRight,prod);
        }

        if(zeroPresent) return Math.max(Math.max(maxLeft,maxRight),0);
        return Math.max(maxLeft,maxRight);
    }
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArray(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }
}
class MAXIMUMPRODUCTSUBARRAYOPTIMAL
{
    static int maxProductSubArray(int arr[]) {
        int prod1 = arr[0],prod2 = arr[0],result = arr[0];

        for(int i=1;i<arr.length;i++) {
            int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
            prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
            prod1 = temp;

            result = Math.max(result,prod1);
        }

        return result;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArray(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }
}