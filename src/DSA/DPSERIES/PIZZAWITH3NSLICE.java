package DSA.DPSERIES;

import java.util.Vector;

public class PIZZAWITH3NSLICE {
    PIZZAWITH3NSLICE(){

    }
    public static int solve(int i,int e,Vector<Integer>slices,int n){
        if (n==0||i>e){
            return 0;
        }
        int take=slices.get(i)+solve(i+2,e,slices,n-1);
        int nottake=solve(i+1,e,slices,n);
        return Math.max(take,nottake);
    }
    public static int solvememo(int i,int e,Vector<Integer>slices,int n,int[][] dp){
        if (n==0||i>e){
            return 0;
        }
        if (dp[i][n]!=-1){
            return dp[i][n];
        }
        int take=slices.get(i)+solvememo(i+2,e,slices,n-1,dp);
        int nottake=solvememo(i+1,e,slices,n,dp);
        dp[i][n]= Math.max(take,nottake);
        return dp[i][n];
    }
    public static int maxslicesize(Vector<Integer>slices){
        int k=slices.size();
        int[][]dp1=new int[k][k];
        for (int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                dp1[i][j]=-1;
            }
        }
        int case1=solve(0,k-2,slices,k/3);
        int case2=solve(1,k-1,slices,k/3);

        int c1=solvememo(0,k-2,slices,k/3,dp1);
        int[][]dp2=new int[k][k];
        for (int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                dp2[i][j]=-1;
            }
        }
        int c2=solvememo(1,k-1,slices,k/3,dp2);

        return Math.max(case1,case2);
    }
    public static int solvetab(Vector<Integer>slices){
        int k=slices.size();
        int[][]dp1=new int[k+2][k+2];
        for (int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                dp1[i][j]=-1;
            }
        }
        int[][]dp2=new int[k+2][k+2];
        for (int i=0;i<k;i++){
            for (int j=0;j<k;j++){
                dp2[i][j]=-1;
            }
        }
        for (int i=k-2;i>=0;i--){
            for (int n=1;n<=k/3;n++){
                int take=slices.get(i)+dp1[i+2][n-1];
                int nottake=dp1[i+1][n];
                dp1[i][n]= Math.max(take,nottake);
            }
        }
        for (int i=k-1;i>=0;i--){
            for (int n=1;n<=k/3;n++){
                int take=slices.get(i)+dp2[i+2][n-1];
                int nottake=dp2[i+1][n];
                dp2[i][n]= Math.max(take,nottake);
            }
        }
        return Math.max(dp1[0][k/3],dp2[1][k/3]);
    }
    public static int moreoptimised(Vector<Integer>slices){
        int k=slices.size();
        Vector<Integer>prv=new Vector<>(k+2);
        for (int i=0;i<k;i++){
            prv.add(0);
        }
        Vector<Integer>curr=new Vector<>(k+2);
        for (int i=0;i<k;i++){
            prv.add(0);
        }
        Vector<Integer>next=new Vector<>(k+2);
        for (int i=0;i<k;i++){
            prv.add(0);
        }
        Vector<Integer>prv2=new Vector<>(k+2);
        for (int i=0;i<k;i++){
            prv2.add(0);
        }
        Vector<Integer>curr2=new Vector<>(k+2);
        for (int i=0;i<k;i++){
            curr2.add(0);
        }
        Vector<Integer>next2=new Vector<>(k+2);
        for (int i=0;i<k;i++){
            next2.add(0);
        }
        for (int i=k-2;i>=0;i--){
            for (int n=1;n<=k/3;n++){
                int take=slices.get(i)+next.get(n-1);
                int nottake=curr.get(n);
                prv.add(n,Math.max(take,nottake));
            }
            next=curr;
            curr=prv;
        }
        for (int i=k-1;i>=0;i--){
            for (int n=1;n<=k/3;n++){
                int take=slices.get(i)+next2.get(n-1);
                int nottake=curr2.get(n);
                prv2.add(n,Math.max(take,nottake));
            }
            next2=curr2;
            curr2=prv2;
        }
        return Math.max(next.get(k/3),next2.get(k/3));
    }
}
