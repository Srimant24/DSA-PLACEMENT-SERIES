package DSA.DPSERIES;

public class CUTSEGMENT {
    CUTSEGMENT(){

    }
    public int cutsegments(int n,int x,int y,int z){
        int[] dp=new int[n+1];
        int ans=solverecurr(n,x,y,z);
        int ans1=solvememmo(n,x,y,z,dp);
        int ans2=solvetabu(n,x,y,z);
        if (ans<0){
            return 0;
        }
        return ans;
    }

    public int solvememmo(int n, int x, int y, int z, int[] dp) {
        if (n==0){
            return 0;
        }
        if (n<0){
            return Integer.MIN_VALUE;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        int a=solvememmo(n-x,x,y,z,dp)+1;
        int b=solvememmo(n-y,x,y,z,dp)+1;
        int c=solvememmo(n-z,x,y,z,dp)+1;

        dp[n]= Math.max(a,Math.max(b,c));
        return dp[n];
    }
    public int solvetabu(int n,int x,int y,int z){
        int[] dp1=new int[n+1];
        for (int i=0;i< dp1.length;i++){
            dp1[i]=Integer.MIN_VALUE;
        }
        dp1[0]=0;
        for (int i=1;i<dp1.length;i++){
            if (i-x>=0){
                dp1[i]=Math.max(dp1[i],dp1[i-x]+1);
            }
            if (i-y>=0){
                dp1[i]=Math.max(dp1[i],dp1[i-y]+1);
            }
            if (i-z>=0){
                dp1[i]=Math.max(dp1[i],dp1[i-z]+1);
            }
        }
        if (dp1[n]<0){
            return 0;
        }
        return dp1[n];
    }

    public int solverecurr(int n, int x, int y, int z) {
        if (n==0){
            return 0;
        }
        if (n<0){
            return Integer.MIN_VALUE;
        }
        int a=solverecurr(n-x,x,y,z)+1;
        int b=solverecurr(n-y,x,y,z)+1;
        int c=solverecurr(n-z,x,y,z)+1;

        return Math.max(a,Math.max(b,c));
    }
}
