package DSA.PATTERN;

public class P18 {
    public static void main(String[] args) {
        int rows = 5; // Number of rows in the pattern

        int num = 1;
        // Outer loop to iterate through each row
        for (int i = rows; i >= 1; i--) {
            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
            }

            num++; // Increment the number for the next row
            System.out.println(); // Move to the next line for the next row
        }
    }
}
