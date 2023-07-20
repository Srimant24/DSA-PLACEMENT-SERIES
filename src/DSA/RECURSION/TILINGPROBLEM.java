package DSA.RECURSION;

public class TILINGPROBLEM {
    public static int placeTiles(int n, int m) {
        if(n < m) {
            return 1;
        } else if(n == m) {
            return 2;
        }


        return placeTiles(n-1, m) + placeTiles(n-m, m);
    }

}
