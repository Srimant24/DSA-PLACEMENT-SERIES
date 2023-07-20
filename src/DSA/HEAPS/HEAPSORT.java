package DSA.HEAPS;
import java.util.*;
public class HEAPSORT {
    public void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i;//for 0 based it is 2*i+1
        int right = 2 * i + 1;//for 0 based it is 2*i+2

        if (left <= n && arr[left] > arr[largest]) {//replace <= with <
            largest = left;
        }
        if (right <= n && arr[right] > arr[largest]) {//replace  >= with  >
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    public void heapsort(int[] nums, int size) {
        for (int i = size / 2; i >0; i--) { //i = size / 2-1;i>=0
            heapify(nums, size, i);
        }

        int t = size;
        while (t > 1) {//for 0 based it should be >0
            swap(nums, 1, t);//swap nums of 0 with nums of t
            t--;
            heapify(nums, t, 1);//replace 1 with 0
        }
    }

    public static void main(String[] args) {
        HEAPSORT heap = new HEAPSORT();
        int[] nums = { -1, 23, 54, 12, 34, 43 };
        int size = nums.length-1;

        heap.heapsort(nums, size);

        for (int j = 1; j <= size; j++) {
            System.out.println(nums[j]);
        }
    }
}
