package DSA.DPSERIES;

public class SUMOFNONADJACENTNODES {
    SUMOFNONADJACENTNODES(){

    }
    public int solvereurursion(int[] num,int i){//i=nums.length-1
        if (i<0){
            return 0;
        }
        if (i==0){
            return num[0];
        }
        int include=solvereurursion(num,i-2)+num[i];
        int exclude=solvereurursion(num,i-1);
         return Math.max(include,exclude);
    }
    public int solvememo(int[] num,int i,int[] dp){
        if (i<0){
            return 0;
        }
        if (i==0){
            return num[0];
        }
        if (dp[i]!=-1){
            return dp[i];
        }
        dp[i]=Math.max(solvememo(num,i-2,dp)+num[i],solvememo(num,i-1,dp));
        return dp[i];
    }
    public int tabulation(int[] num){
        int[] dp1 = new int[num.length +1];
        for (int i=0;i<dp1.length;i++){
            dp1[i]=0;
        }
        dp1[0] = num[0];
        for (int j=1;j< dp1.length;j++){
            dp1[j]=Math.max(dp1[j-2]+num[j],dp1[j-1]);
        }
        return dp1[dp1.length-1];
    }
    public int optimised(int[] num){
        int a=0;
        int b=num[0];
        for (int i=1;i< num.length;i++){
            int temp=b;
            int include=b+num[i];
            int exclude=a;
            int ans=Math.max(include,exclude);
            b=ans;
            a=temp;
        }
        return b;
    }
}
