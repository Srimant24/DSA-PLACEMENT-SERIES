package DSA.RECURSION;

public class FIBBONACCISEQ {
    public static void printFactorial(int a, int b, int n) {
        if(n == 0) {
            return;
        }
        System.out.println(a);
        printFactorial(b, a+b, n-1);
    }
}
