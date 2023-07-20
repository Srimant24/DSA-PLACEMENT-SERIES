package DSA.DPSERIES;

import java.util.Collections;
import java.util.Vector;

public class REDUCINGDISHES {
    REDUCINGDISHES(){

    }
    public  static int solve(Vector<Integer>satisfaction,int i,int time){
        if (i==satisfaction.size()){
            return 0;
        }
        int include=satisfaction.get(i)*(time+1)+solve(satisfaction, i+1, time+1);
        int exclude=solve(satisfaction, i+1, time);
        return Math.max(include,exclude);
    }
    public static int solvememo(Vector<Integer>satisfaction,int i,int time,int[][] dp){
        if (i==satisfaction.size()){
            return 0;
        }
        if (dp[i][time]!=-1){
            return dp[i][time];
        }
        int include=satisfaction.get(i)*(time+1)+solvememo(satisfaction, i+1, time+1,dp);
        int exclude=solvememo(satisfaction, i+1, time,dp);
        dp[i][time]= Math.max(include,exclude);
        return dp[i][time];
    }
    public static int solvetab(Vector<Integer>satisfaction){
        int n=satisfaction.size();
        int[][]dp=new int[n+1][n+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int j=n-1;j>=0;j++){
                int include=satisfaction.get(i)*(j+1)+dp[i+1][j+1];
                int exclude=dp[i+1][j];
                dp[i][j]= Math.max(include,exclude);

            }
        }
        return dp[0][0];
    }
    public static int optimised(Vector<Integer>satisfaction){
        int n=satisfaction.size();
        Vector<Integer>curr=new Vector<>(n+1);
        Vector<Integer>next=new Vector<>(n+1);
        for (int i=0;i<n;i++){
            curr.add(i,0);
            next.add(i,0);
        }
        for (int i=n-1;i>=0;i--){
            for (int j=n-1;j>=0;j++){
                int include=satisfaction.get(i)*(j+1)+next.get(j+1);
                int exclude=next.get(j);
                curr.add(j,Math.max(include,exclude));

            }
            next=curr;
        }
        return next.get(0);
    }
    public static int maxsatisfaction(Vector<Integer>satisfaction){
        int n=satisfaction.size();
        int[][]dp=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        Collections.sort(satisfaction);
        solvememo(satisfaction,0,0,dp);
        return solve(satisfaction,0,0);
    }
}
