package DSA.ARRAY;
import java.util.ArrayList;
import java.util.List;
public class INTERSECTION {
    public static List<Integer> findArrayIntersection(List<Integer> arr1, List<Integer> arr2) {
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i).equals(arr2.get(j))) {
                ans.add(arr1.get(i));
                i++;
                j++;
            } else if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(4);
        arr1.add(5);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(5);
        arr2.add(7);

        List<Integer> result = findArrayIntersection(arr1, arr2);
        System.out.println(result); // Output: [2, 5]
    }
}
