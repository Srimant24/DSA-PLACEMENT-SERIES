package DSA.PATTERN;

public class P15 {
    public static void main(String[] args) {
        int rows = 5; // Number of rows in the pattern

        // Outer loop to iterate through each row
        for (int i = 1; i <= rows; i++) {
            // Inner loop to print spaces
            for (int j = i; j < rows; j++) {
                System.out.print(" ");
            }

            // Inner loop to print stars
            for (int k = 1; k <= i * 2 - 1; k++) {
                if (k == 1 || k == i * 2 - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println(); // Move to the next line for the next row
        }
    }
}
