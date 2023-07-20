package DSA.RECURSION;

public class PRINTXPOWN {
    public static int printPower(int x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        int x_ = printPower(x, n-1);
        int xn = x * x_;
        return xn;
    }
}
