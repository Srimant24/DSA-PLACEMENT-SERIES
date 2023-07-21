package DSA.PATTERN;

public class P16 {
    public static void main(String[] args) {
        int rows = 5; // Number of rows in the triangle

        // Outer loop to iterate through each row
        for (int i = 0; i < rows; i++) {
            // Print spaces
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }

            // Calculate and print the elements for the current row
            int num = 1;
            for (int k = 0; k <= i; k++) {
                System.out.print(num + " ");
                num = num * (i - k) / (k + 1);
            }

            System.out.println(); // Move to the next line for the next row
        }
    }
}
