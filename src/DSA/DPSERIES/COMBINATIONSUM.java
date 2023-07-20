package DSA.DPSERIES;

import java.util.Vector;

public class COMBINATIONSUM {
    COMBINATIONSUM(){

    }
    public static int findways(Vector<Integer>num,int tar){
        int[] dp=new int[tar+1];
        for (int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int ans1=solvememo(num,tar,dp);
        int ans=solverecurr(num,tar);
        int ans2=solvetabu(num, tar);
        return ans;
    }
    public static int solverecurr(Vector<Integer>num,int tar){
        if (tar==0){
            return 1;
        }
        if (tar<1){
            return 0;
        }
        int ans=0;
        for (int i=0;i< num.size();i++){
            ans+=solverecurr(num,tar-num.get(i));
        }
        return ans;
    }
    public static int solvememo(Vector<Integer>num,int tar,int[] dp){
        if (tar==0){
            return 1;
        }
        if (tar<1){
            return 0;
        }
        if (dp[tar]!=-1){
            return dp[tar];
        }
        int ans=0;
        for (int i=0;i< num.size();i++){
            ans+=solvememo(num,tar-num.get(i),dp);
        }
        dp[tar]=ans;
        return dp[tar];
    }
    public static int solvetabu(Vector<Integer>num,int tar){
        int[] dp1=new int[tar+1];
        for (int i=0;i<dp1.length;i++){
            dp1[i]=0;
        }
        dp1[0]=1;
        int ans=0;
        for (int i=1;i<=tar;i++){
            for (int j=0;j< num.size();j++){
                if (i-num.get(j)>=0){
                    dp1[i]+=dp1[i-num.get(j)];
                }
            }
        }
        return dp1[tar];
    }
}
