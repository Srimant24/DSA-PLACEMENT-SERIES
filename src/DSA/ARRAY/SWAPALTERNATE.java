package DSA.ARRAY;
import java.util.Arrays;
public class SWAPALTERNATE {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swapAlternate(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {
            if (i + 1 < arr.length) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] even = {5, 2, 9, 4, 7, 6, 1, 0};
        int[] odd = {11, 33, 9, 76, 43};

        swapAlternate(even);
        printArray(even); // Output: 2 5 4 9 6 7 0 1

        System.out.println();

        swapAlternate(odd);
        printArray(odd); // Output: 33 11 76 9 43
    }
}
