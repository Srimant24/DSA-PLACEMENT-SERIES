package DSA.ARRAY;
import java.util.*;
public class INTERSECTIONOFTWOSORTEDARRAYS {
    public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B) {


        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        // to traverse the arrays
        while (i < A.length && j < B.length) {

            //if current element in i is smaller
            if (A[i] < B[j]) {
                i++;
            } else if (B[j] < A[i]) {
                j++;
            } else {

                //both elements are equal
                ans.add(A[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}
