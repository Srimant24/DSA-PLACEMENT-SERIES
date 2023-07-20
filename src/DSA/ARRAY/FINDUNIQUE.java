package DSA.ARRAY;

public class FINDUNIQUE {
    public static int findUnique(int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1 };

        int result = findUnique(arr);
        System.out.println("Unique element is: " + result); // Output: 3
    }
}
