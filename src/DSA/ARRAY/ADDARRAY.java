package DSA.ARRAY;
import java.util.ArrayList;
import java.util.Collections;
public class ADDARRAY {
    public static ArrayList<Integer> reverse(ArrayList<Integer> v) {
        int s = 0;
        int e = v.size() - 1;
        while (s < e) {
            Collections.swap(v, s++, e--);
        }
        return v;
    }

    public static ArrayList<Integer> findArraySum(ArrayList<Integer> a, int n, ArrayList<Integer> b, int m) {
        int i = n - 1;
        int j = m - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int val1 = a.get(i);
            int val2 = b.get(j);

            int sum = val1 + val2 + carry;

            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = a.get(i) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
        }

        while (j >= 0) {
            int sum = b.get(j) + carry;
            carry = sum / 10;
            int value = sum % 10;
            ans.add(value);
            j--;
        }

        while (carry != 0) {
            int sum = carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
        }

        return reverse(ans);
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> a = new ArrayList<>();
        a.add(9);
        a.add(9);
        a.add(9);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);

        ArrayList<Integer> result = findArraySum(a, a.size(), b, b.size());
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
