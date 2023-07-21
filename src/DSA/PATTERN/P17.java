package DSA.PATTERN;

public class P17 {
    public static void main(String[] args) {
        int rows = 5; // Number of rows in the pattern

        // Outer loop to iterate through each row
        for (int i = 1; i <= rows; i++) {
            // Print spaces
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // Print numbers
            int num = 1;
            for (int k = 1; k <= i; k++) {
                System.out.print(num + " ");
                num++;
            }

            System.out.println(); // Move to the next line for the next row
        }
    }
}
//            1
//           1 2
//          1 2 3
//         1 2 3 4
//        1 2 3 4 5
