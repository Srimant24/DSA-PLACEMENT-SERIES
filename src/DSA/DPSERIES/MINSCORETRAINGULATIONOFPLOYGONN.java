package DSA.DPSERIES;

import java.util.Vector;

public class MINSCORETRAINGULATIONOFPLOYGONN {
    MINSCORETRAINGULATIONOFPLOYGONN(){

    }
    public static int solve(Vector<Integer>vector,int i,int j){
        if (i+1==j){
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        for (int k=i+1;k<j;k++){
            ans=Math.min(ans,(vector.get(i)*vector.get(j)*vector.get(k)+solve(vector, i, k)+solve(vector, k, j)));
        }
        return ans;
    }
    public static int solvememo(Vector<Integer>vector,int i,int j,int[][]dp){
        if (i+1==j){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for (int k=i+1;k<j;k++){
            ans=Math.min(ans,(vector.get(i)*vector.get(j)*vector.get(k)+solvememo(vector, i, k,dp)+solvememo(vector, k, j,dp)));
        }
        dp[i][j]= ans;
        return dp[i][j];
    }
    public static int minscore(Vector<Integer>values){
        int n= values.size();
        int[][]dp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        solvememo(values,0,n-1,dp);
        tabu(values);
        return solve(values,0,n-1);
    }
    public static int tabu(Vector<Integer>values){
        int n= values.size();
        int[][]dp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
        for (int i=n-1;i>0;i--){
            for (int j=i+2;j<n;j++){
                int ans=Integer.MAX_VALUE;
                for (int k=i+1;k<j;k++){
                    ans=Math.min(ans,(values.get(i)*values.get(j)*values.get(k)+dp[i][k]+dp[k][j]));
                }
                dp[i][j]= ans;
                return dp[i][j];
            }
        }
        return dp[0][n-1];
    }
}
