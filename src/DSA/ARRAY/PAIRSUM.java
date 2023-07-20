package DSA.ARRAY;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PAIRSUM {
    public static List<List<Integer>> pairSum(List<Integer> arr, int s) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) + arr.get(j) == s) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(Math.min(arr.get(i), arr.get(j)));
                    temp.add(Math.max(arr.get(i), arr.get(j)));
                    ans.add(temp);
                }
            }
        }
        ans.sort((a, b) -> {
            int cmp = a.get(0).compareTo(b.get(0));
            return cmp != 0 ? cmp : a.get(1).compareTo(b.get(1));
        });
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int targetSum = 7;

        List<List<Integer>> result = pairSum(arr, targetSum);
        for (List<Integer> pair : result) {
            System.out.println(pair.get(0) + ", " + pair.get(1));
        }
        // Output: 1, 6
        //         2, 5
        //         3, 4
    }
}
