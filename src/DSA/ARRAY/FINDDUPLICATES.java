package DSA.ARRAY;
import java.util.List;
public class FINDDUPLICATES {
    public static int findDuplicate(List<Integer> arr) {
        int ans = 0;

        // XOR ing all array elements
        for (int i = 0; i < arr.size(); i++) {
            ans = ans ^ arr.get(i);
        }

        // XOR [1, n-1]
        for (int i = 1; i < arr.size(); i++) {
            ans = ans ^ i;
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 2, 3, 3, 4, 5);

        int result = findDuplicate(arr);
        System.out.println("Duplicate element is: " + result); // Output: 3
    }
}
