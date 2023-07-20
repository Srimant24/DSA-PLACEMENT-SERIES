package DSA.DPSERIES;

import java.util.*;

public class LONGESTARITHMATICSUBSEQUENCE {
    LONGESTARITHMATICSUBSEQUENCE(){

    }
    public static int solve(int i,int diff,int[] arr){
        if (i<0){
            return 0;
        }
        int len=0;
        for (int j=i-1;j>=0;j--){
            if (arr[i]-arr[j]==diff){
                len=Math.max(len,1+solve(j,diff,arr));
            }
        }
        return len;
    }
    public static int lrngthoflongestAP(int[] arr,int n){
        if (n<=2){
            return n;
        }
        Map<Integer,Integer>[] dp1= new Map[n+1];
        int len=0;
        int len1=0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
               // len=Math.max(len,2+solve(i,arr[j]-arr[i],arr));
                len1=Math.max(len,2+solvemem(i,arr[j]-arr[i],arr,dp1));
            }
        }
        return len;
    }

    public static int solvemem(int i, int diff, int[] arr, Map<Integer, Integer>[] dp1) {
        if (i < 0) {
            return 0;
        }
        if (dp1[i].containsKey(diff)) {
            return dp1[i].get(diff);
        }
        int len = 0;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[i] - arr[j] == diff) {
                len = Math.max(len, 1 + solve(j, diff, arr));
            }
        }
        dp1[i].put(diff,len);
        return dp1[i].get(diff);
    }
    public int solvetab(int[] arr,int n){
        if (n<=2){
            return n;
        }
        int ans=0;
        Map<Integer,Integer>[] dp1= new Map[n+1];
        for (int i=0;i<dp1.length;i++){
            dp1[i].put(i,null);
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                int diff=arr[i]-arr[j];
                int count=1;
                if (dp1[j].containsKey(diff)){
                    count=dp1[i].get(diff);
                }
                dp1[i].put(diff,1+count);
                ans=Math.max(ans,dp1[i].get(diff));
            }
        }
        return ans;
    }
}
