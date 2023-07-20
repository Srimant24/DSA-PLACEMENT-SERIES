package DSA.RECURSION;
import java.util.*;
public class PRINTUNIQUESUBSEQUENCE {
    public static void printSubseq(String str, int idx, String res, HashSet<String> allSubseq) {
        if(idx == str.length()) {
            if(allSubseq.contains(res)) {
                return;
            }
            allSubseq.add(res);
            System.out.println(res);
            return;
        }

         //choose
        printSubseq(str, idx+1, res+str.charAt(idx), allSubseq);
         //don't choose
        printSubseq(str, idx+1, res, allSubseq);
    }
}
