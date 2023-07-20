package DSA.DPSERIES;
//LONGEST PALINDROMIC SUBSEQUNECE
public class LPS {
    LPS(){

    }
    public int slovelps(String a){
        String b="";
        for(int i=a.length()-1;i>=0;i++){
            char currentchar=a.charAt(i);
             b=b+currentchar;
        }
        return optimised(a,b);
    }
    public static int optimised(String a,String b){
        int [] curr=new int[b.length()+1];
        for (int i=0;i< curr.length;i++){
            curr[i]=0;
        }
        int [] next=new int[b.length()+1];
        for (int i=0;i< next.length;i++){
            next[i]=0;
        }
        for (int i=a.length()-1;i>=0;i--){
            for (int j=b.length()-1;j>=0;j--){
                int len=0;
                if (a.charAt(i) == b.charAt(j)) {
                    len=1+next[j+1];
                }
                else {
                    len=Math.max(next[j],curr[j+1]);
                }
                curr[j]= len;
            }
            next=curr;
        }
        return next[0];
    }
}
