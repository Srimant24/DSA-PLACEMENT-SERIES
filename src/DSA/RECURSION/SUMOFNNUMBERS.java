package DSA.RECURSION;

public class SUMOFNNUMBERS {
    class Recursion1 {
        public static void printSum(int n, int sum) {
            if(n == 0) {
                System.out.println(sum);
                return;
            }
            sum += n;
            printSum(n-1, sum);
        }
    }
}
