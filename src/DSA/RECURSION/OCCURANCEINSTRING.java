package DSA.RECURSION;

public class OCCURANCEINSTRING {
    public static int first = -1;
    public static int last = -1;
    public static void getIndices(String str, char el, int idx) {
        if(idx == str.length()) {
            return;
        }
        if(str.charAt(idx) == el) {
            if(first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }
        getIndices(str, el, idx+1);
    }
}
