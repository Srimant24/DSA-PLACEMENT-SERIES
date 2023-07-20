package DSA.RECURSION;

public class PRINTNO {
    public static void printNumbers(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n-1);
    }
}
