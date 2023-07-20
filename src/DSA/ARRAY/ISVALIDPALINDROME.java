package DSA.ARRAY;

public class ISVALIDPALINDROME {
    private boolean valid(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
            return true;
        }

        return false;
    }

    private char toLowerCase(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return ch;
        } else {
            char temp = (char) (ch - 'A' + 'a');
            return temp;
        }
    }

    private boolean checkPalindrome(String a) {
        int s = 0;
        int e = a.length() - 1;

        while (s <= e) {
            if (a.charAt(s) != a.charAt(e)) {
                return false;
            } else {
                s++;
                e--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        // Remove unwanted characters
        StringBuilder temp = new StringBuilder();

        for (int j = 0; j < s.length(); j++) {
            if (valid(s.charAt(j))) {
                temp.append(s.charAt(j));
            }
        }

        // Convert to lowercase
        for (int j = 0; j < temp.length(); j++) {
            temp.setCharAt(j, toLowerCase(temp.charAt(j)));
        }

        // Check for palindrome
        return checkPalindrome(temp.toString());
    }
}
