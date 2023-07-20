package DSA.RECURSION;

import java.util.ArrayList;

public class SUBSETSOFSETS {
    public static void printSubsets(ArrayList<Integer> subset) {
        for(int i=0; i<subset.size(); i++) {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }
    public static void findSubsets(int n, ArrayList<Integer> subset) {
        if(n == 0) {
            printSubsets(subset);
            return;
        }
        subset.add(n);
        findSubsets(n-1, subset);
        subset.remove(subset.size() - 1);
        findSubsets(n-1, subset);

    }
}
