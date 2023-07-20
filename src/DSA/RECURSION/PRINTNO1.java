package DSA.RECURSION;

public class PRINTNO1 {
    public static void printNumbers(int n) {
        if(n == 6) {
            return;
        }
        System.out.println(n);
        printNumbers(n+1);
    }
}
