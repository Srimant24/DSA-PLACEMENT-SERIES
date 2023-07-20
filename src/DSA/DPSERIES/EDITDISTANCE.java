package DSA.DPSERIES;
//min operation take to match two strings
public class EDITDISTANCE {
    EDITDISTANCE(){

    }
    public static int minop(String a,String b){
        int[][] dp = new int[a.length()][b.length()];
        for (int i=0;i<a.length();i++){
            for (int k=0;k<b.length();k++){
                dp[i][k]=-1;
            }
        }
        if (a.length()==0){
            return b.length();
        }
        if (b.length()==0){
            return a.length();
        }
        solvemem(a,b,0,0,dp);
        solvetab(a,b);
        return solve(a,b,0,0);
    }

    public static int solve(String a, String b,int i,int j) {
        if (i==a.length()){
           return b.length()-j;
        }
        if (j==b.length()){
            return a.length()-i;
        }
        int ans=0;
        if (a.charAt(i) == b.charAt(j)) {
            return solve(a,b,i+1,j+1);
        }
        else {
            int insertans=1+solve(a,b,i,j+1);
            int deleteans=1+solve(a,b,i+1,j);
            int replace=1+solve(a,b,i+1,j+1);
            ans= Math.min(insertans,Math.min(deleteans,replace));
        }
        return ans;
    }
    public static int solvemem(String a, String b,int i,int j,int[][] dp) {
        if (i==a.length()){
            return b.length()-j;
        }
        if (j==b.length()){
            return a.length()-i;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if (a.charAt(i) == b.charAt(j)) {
            return solvemem(a,b,i+1,j+1,dp);
        }
        else {
            int insertans=1+solvemem(a,b,i,j+1,dp);
            int deleteans=1+solvemem(a,b,i+1,j,dp);
            int replace=1+solvemem(a,b,i+1,j+1,dp);
            ans= Math.min(insertans,Math.min(deleteans,replace));
        }
        dp[i][j]=ans;
        return dp[i][j];
    }
    public static int solvetab(String a, String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i=0;i< dp.length;i++) {
            for (int k = 0; k < dp[i].length; k++) {
                dp[i][k] = 0;
            }
        }
            for (int j=0;j<b.length();j++){
                dp[a.length()][j]=b.length()-j;
            }
            for (int i=0;i<a.length();i++){
                dp[i][b.length()]=a.length()-i;
            }
            for (int i=a.length()-1;i>=0;i--){
                for (int j=b.length()-1;j>=0;j--){
                    int ans=0;
                    if (a.charAt(i) == b.charAt(j)) {
                        ans= dp[i+1][j+1];
                    }
                    else {
                        int insertans=1+dp[i][j+1];
                        int deleteans=1+dp[i+1][j];
                        int replace=1+dp[i+1][j+1];
                        ans= Math.min(insertans,Math.min(deleteans,replace));
                    }
                    dp[i][j]=ans;
                }
            }
        return dp[0][0];
        }
        public static int optimised(String a, String b){
            int [] curr=new int[b.length()+1];
            for (int i=0;i< curr.length;i++){
                curr[i]=0;
            }
            int [] next=new int[b.length()+1];
            for (int i=0;i< next.length;i++){
                next[i]=0;
            }
            for (int j=0;j<b.length();j++){
                next[j]=b.length()-j;
            }
            for (int i=a.length()-1;i>=0;i--){
                for (int j=b.length()-1;j>=0;j--){
                    curr[b.length()]=a.length()-i;
                    int ans=0;
                    if (a.charAt(i) == b.charAt(j)) {
                        ans= next[j+1];
                    }
                    else {
                        int insertans=1+curr[j+1];
                        int deleteans=1+next[j];
                        int replace=1+next[j+1];
                        ans= Math.min(insertans,Math.min(deleteans,replace));
                    }
                    curr[j]=ans;
                }
                next=curr;
            }
            return next[0];
        }
    }
