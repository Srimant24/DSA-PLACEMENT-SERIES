package DSA.DPSERIES;

public class PARTITIONWQUALSUBSETSUM {
    PARTITIONWQUALSUBSETSUM(){

    }
    public static boolean equalpartition(int n,int[] arr){
        int total=0;
        for (int i=0;i< n;i++){
            total+=arr[i];
        }
        if (total%2==0){

            int tar=total/2;
            boolean[][] dp=new boolean[n+1][tar+1];
            for (int i=0;i<n;i++){
                for (int j=0;j<tar;j++){
                    dp[i][j]=false;
                }
            }
            return solve(0,n,arr,tar);
        }else {
            return false;
        }
    }

    public static boolean solve(int i,int n, int[] arr,int tar) {
        if (i>=arr.length){
            return false;
        }
        if (tar==0){
            return true;
        }
        if (tar<0){
            return false;
        }
        boolean inc=solve(i+1,n,arr,tar-arr[i]);
        boolean excl=solve(i+1,n,arr,tar);
        return (inc || excl);
    }
    public static boolean solvemeo(int i,int n, int[] arr,int tar,boolean[][] dp) {
        if (i>=n){
            return false;
        }
        if (tar==0){
            return true;
        }
        if (tar<0){
            return false;
        }
        if (dp[i][tar]!=false){
            return dp[i][tar];
        }
        boolean inc=solvemeo(i+1,n,arr,tar-arr[i],dp);
        boolean excl=solvemeo(i+1,n,arr,tar,dp);
        dp[i][tar]= (inc || excl);
        return dp[i][tar];
    }
    public static boolean solvetab(int n, int[] arr,int tar){
        boolean[][] dp=new boolean[n+1][tar+1];
        for (int i=0;i<n;i++){
            for (int j=0;j<tar;j++){
                dp[i][j]=false;
            }
        }
        for (int i=0;i<n;i++){
            dp[i][0]=true;
        }
        for (int i=n-1;i>=0;i--){
            for (int j=1;j<=tar;j++){
                boolean inc=dp[i+1][tar-arr[i]];
                boolean excl=dp[i+1][tar];
                dp[i][tar]= (inc || excl);
            }
        }
        return dp[0][tar];
    }
    public static boolean optimised(int n, int[] arr,int tar){
        boolean[] curr=new boolean[tar+1];
        for (int i=0;i< curr.length;i++){
            curr[i]=false;
        }
        curr[0]=true;
        boolean[] next=new boolean[tar+1];
        for (int i=0;i< next.length;i++){
            next[i]=false;
        }
        next[0]=true;
        for (int i=n-1;i>=0;i--){
            for (int j=1;j<=tar;j++){
                boolean inc=next[tar-arr[i]];
                boolean excl=next[tar];
                curr[tar]= (inc || excl);
            }
            next=curr;
        }
        return next[tar];
    }
}
