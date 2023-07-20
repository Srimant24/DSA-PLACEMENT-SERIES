package DSA.RECURSION;

public class DUPLICATESFROMSTRING {
    public static String removeDuplicates(String str, int idx, boolean present[]) {
        if(idx == str.length()) {
            return "";
        }
        char curr = str.charAt(idx);
        if(present[curr-'a']) {
            return removeDuplicates(str, idx+1, present);
        } else {
            present[curr-'a'] = true;
            return curr + removeDuplicates(str, idx+1, present);
        }
    }
}
