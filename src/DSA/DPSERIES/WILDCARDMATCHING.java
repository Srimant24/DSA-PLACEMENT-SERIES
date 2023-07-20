package DSA.DPSERIES;

public class WILDCARDMATCHING {
    WILDCARDMATCHING(){

    }
    public static boolean ismatch(String s,String p){
        int[][] dp = new int[s.length()+1][p.length()+1];
        for (int i=0;i<dp.length;i++){
            for (int k=0;k<dp[i].length;k++){
                dp[i][k]=-1;
            }
        }
        if(solvemem(s,p,s.length()-1,p.length()-1,dp)==1){
            return true;
        }
        else {
            return false;
        }
       // return solve(s,p,s.length()-1,p.length()-1);
    }

    public static boolean solve(String s, String p, int i, int j) {
        if (i<0 && j<0){
            return true;
        }
        if (i>=0 && j<0){
            return false;
        }
        if (i<0 && j>=0){
            for (int k=0;k<=j;k++){
                if (p.charAt(k)=='*'){
                    return true;
                }else {
                    return false;
                }
            }
        }
        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            return solve(s,p,i-1,j-1);
        } else if (p.charAt(j)=='*') {
            return (solve(s,p,i,j-1) ||solve(s,p,i-1,j));
        }else {
            return false;
        }
    }
    public static int solvemem(String s, String p, int i, int j, int[][] dp) {
        if (i==0 && j==0){
            return 1;
        }
        if (i>0 && j==0){
            return 0;
        }
        if (i==0 && j>0){
            for (int k=0;k<=j;k++){
                if (p.charAt(k-1)!='*'){
                    return 0;
                }else {
                    return 1;
                }
            }
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
           return dp[i][j]= solvemem(s,p,i-1,j-1,dp);
        } else if (p.charAt(j-1)=='*') {
           return dp[i][j]= (solvemem(s,p,i,j-1,dp) |solvemem(s,p,i-1,j,dp));
        }else {
            return 0;
        }
    }
    public static int solvetab(String s,String p){
        int[][] dp = new int[s.length()+1][p.length()+1];
        for (int i=0;i<dp.length;i++){
            for (int k=0;k<dp[i].length;k++){
                dp[i][k]=0;
            }
        }
        for (int j=1;j<=p.length();j++){
            int flag=1;
            for (int k=0;k<=j;k++){
                if (p.charAt(k-1)!='*'){
                    flag=0;
                    break;
                }
                dp[0][j]=flag;
            }
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                     dp[i][j]= dp[i-1][j-1];
                } else if (p.charAt(j-1)=='*') {
                     dp[i][j]= (dp[i][j-1] |dp[i-1][j]);
                }else {
                    dp[i][j]= 0;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static int optimised(String s,String p){
        int [] prv=new int[p.length()+1];
        for (int i=0;i< prv.length;i++){
            prv[i]=0;
        }
        int [] curr=new int[p.length()+1];
        for (int i=0;i< curr.length;i++){
            curr[i]=0;
        }
        prv[0]=0;
        for (int j=1;j<=p.length();j++){
            int flag=1;
            for (int k=0;k<=j;k++){
                if (p.charAt(k-1)!='*'){
                    flag=0;
                    break;
                }
                prv[j]=flag;
            }
        }
        for (int i=1;i<=s.length();i++){
            for (int j=1;j<=p.length();j++){
                if (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    curr[j]= prv[j-1];
                } else if (p.charAt(j-1)=='*') {
                    curr[j]= (curr[j-1] |prv[j]);
                }else {
                    curr[j]= 0;
                }
            }
            prv=curr;
        }
        return prv[p.length()];
    }
}
