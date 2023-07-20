package DSA.RECURSION;

public class PRINTSUBSEQUENCEOFSTRING {
    public static void printSubseq(String str, int idx, String res) {
        if(idx == str.length()) {
            System.out.println(res);
            return;
        }
//choose
        printSubseq(str, idx+1, res+str.charAt(idx));
//don't choose
        printSubseq(str, idx+1, res);
    }
}
