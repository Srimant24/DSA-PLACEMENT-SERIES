package DSA.DPSERIES;

import java.util.Vector;

public class OAND1KNAPSACK {
    OAND1KNAPSACK(){

    }
    public static int solverecur(Vector<Integer>weight,Vector<Integer>value,int i, int w){
        if(i==0){
            if (weight.get(0)<=w){
                return value.get(0);
            }
            else {
                return 0;
            }
        }
        int include=0;
        if (weight.get(i)<=w){
             include=value.get(i)+solverecur(weight, value, i-1, w-weight.get(i));
        }
        int exclude=solverecur(weight, value, i-1, w);
        int ans=Math.max(include,exclude);
        return ans;
    }
    public static int solvememo(Vector<Integer>weight,Vector<Integer>value,int i, int w,int[][] dp){
        if(i==0){
            if (weight.get(0)<=w){
                return value.get(0);
            }
            else {
                return 0;
            }
        }
        if (dp[i][w]!=-1){
            return dp[i][w];
        }
        int include=0;
        if (weight.get(i)<=w){
            include=value.get(i)+solvememo(weight, value, i-1, w-weight.get(i),dp);
        }
        int exclude=solvememo(weight, value, i-1, w,dp);
        dp[i][w]=Math.max(include,exclude);
        return dp[i][w];
    }
    public static int knapsack(Vector<Integer>weight,Vector<Integer>value,int n,int maxweight){
       int ans = solverecur(weight, value, n-1, maxweight);
       int[][] dp=new int[n][maxweight+1];
       for (int i=0;i< n;i++){
           for(int j=0;j<=maxweight;j++){
               dp[i][j]=-1;
           }
          int ans1= solvememo(weight, value, n-1, maxweight,dp);
       }
       int ans2=solvetabu(weight, value, n, maxweight);
       return ans;
    }
    public static int solvetabu(Vector<Integer>weight,Vector<Integer>value,int n,int maxweight){
        int[][] dp1=new int[n][maxweight+1];
        for (int w=weight.get(0);w<=maxweight;w++){
            if (w<=maxweight){
                dp1[0][w]= value.get(0);
            }
            else {
                dp1[0][w]= 0;
            }
        }
        for (int i=1;i< n;i++){
            for (int j=0;j<=maxweight;j++){
                int include=0;
                if (weight.get(i)<=j){
                    include=value.get(i)+dp1[i-1][j-weight.get(i)];
                }
                int exclude=dp1[i-1][j];
                dp1[i][j]=Math.max(include,exclude);
            }
        }
        return dp1[n-1][maxweight];
    }
    public static int optimised(Vector<Integer>weight,Vector<Integer>value,int n,int maxweight){
        Vector<Integer>curr=new Vector<>();
        Vector<Integer>prv=new Vector<>();
        for (int w=weight.get(0);w<=maxweight;w++){
            if (w<=maxweight){
                prv.set(w,value.get(0));
            }
            else {
                prv.set(w,0);
            }
        }
        for (int i=1;i< n;i++){
            for (int j=0;j<=maxweight;j++){
                int include=0;
                if (weight.get(i)<=j){
                    include=value.get(i)+prv.get(j-weight.get(i));
                }
                int exclude=prv.get(j);
                curr.add(j,Math.max(include,exclude));
            }
            prv=curr;
        }
        return prv.get(maxweight);
      }
    public static int moreoptimised(Vector<Integer>weight,Vector<Integer>value,int n,int maxweight){
        Vector<Integer>curr=new Vector<>();
        for (int w=weight.get(0);w<=maxweight;w++){
            if (w<=maxweight){
                curr.set(w,value.get(0));
            }
            else {
                curr.set(w,0);
            }
        }
        for (int i=1;i< n;i++){
            for (int j=maxweight;j>=0;j--){
                int include=0;
                if (weight.get(i)<=j){
                    include=value.get(i)+curr.get(j-weight.get(i));
                }
                int exclude=curr.get(j);
                curr.add(j,Math.max(include,exclude));
            }
        }
        return curr.get(maxweight);
    }
}
