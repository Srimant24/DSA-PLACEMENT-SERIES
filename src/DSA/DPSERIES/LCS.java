package DSA.DPSERIES;

public class LCS {
    LCS(){

    }
    public static int lcs(String a,String b){
        int[][] dp = new int[a.length()][b.length()];
        for (int i=0;i<a.length();i++){
            for (int k=0;k<b.length();k++){
               dp[i][k]=-1;
            }
        }
        return solve(a,b,0,0);
    }

    public static int solve(String a, String b, int i, int j) {
        if(i==a.length()||j==b.length()){
            return 0;
        }
        int len=0;
        if (a.charAt(i) == b.charAt(j)) {
            len=1+solve(a,b,i+1,j+1);
        }
        else {
            len=Math.max(solve(a,b,i+1,j),solve(a,b,i,j+1));
        }
        return len;
    }
    public static int solvemem(String a, String b, int i, int j,int[][] dp) {
        if(i==a.length()||j==b.length()){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int len=0;
        if (a.charAt(i) == b.charAt(j)) {
            len=1+solvemem(a,b,i+1,j+1,dp);
        }
        else {
            len=Math.max(solvemem(a,b,i+1,j,dp),solvemem(a,b,i,j+1,dp));
        }
        dp[i][j]= len;
        return dp[i][j];
    }
    public static int solvetab(String a,String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i=0;i<a.length()+1;i++){
            for (int k=0;k<b.length()+1;k++){
                dp[i][k]=-1;
            }
        }
        for (int i=a.length()-1;i>=0;i--){
            for (int j=b.length()-1;j>=0;j--){
                int len=0;
                if (a.charAt(i) == b.charAt(j)) {
                    len=1+dp[i+1][j+1];
                }
                else {
                    len=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j]= len;
            }
        }
        return dp[0][0];
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
