package DSA.DPSERIES;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class NINJATRIP {
    NINJATRIP(){

    }
   static class pair{
        int days;
        int costtill;
        pair(int days,int costtill){
            this.days=days;
            this.costtill=costtill;
        }
    }
    public static int mincoins(int n, Vector<Integer>days,Vector<Integer>cost){
        int[] dp=new int[n+1];
        for (int i=0;i<n;i++){
            dp[i]=-1;
        }
        return solve(n,days,cost,0);
    }

    public static int solve(int n, Vector<Integer> days, Vector<Integer> cost,int index) {
        if (index>=n){
            return 0;
        }
        int option1=cost.get(0)+solve(n,days,cost,index+1);
        int i=0;
        for ( i=index;i<n && days.get(i)< days.get(index)+7;i++){

        }
        int option2=cost.get(1)+solve(n, days,cost,i);
        for ( i=index;i<n && days.get(i)< days.get(index)+30;i++){

        }
        int option3=cost.get(2)+solve(n, days,cost,i);
        int ans=Math.min(option1,Math.min(option2,option3));
        return ans;
    }
    public static int memo(int n, Vector<Integer> days, Vector<Integer> cost,int index,int[] dp){
        if (index>=n){
            return 0;
        }
        if (dp[index]!=-1){
            return dp[n];
        }
        int option1=cost.get(0)+memo(n,days,cost,index+1,dp);
        int i=0;
        for ( i=index;i<n && days.get(i)< days.get(index)+7;i++);
        int option2=cost.get(1)+memo(n, days,cost,i,dp);
        for ( i=index;i<n && days.get(i)< days.get(index)+30;i++);
        int option3=cost.get(2)+memo(n, days,cost,i,dp);
        dp[index]=Math.min(option1,Math.min(option2,option3));
        return dp[index];
    }
    public static int solvetabu(int n, Vector<Integer> days, Vector<Integer> cost){
        int[] dp1=new int[n+1];
        for (int i=0;i<n;i++){
            dp1[i]=Integer.MAX_VALUE;
        }
        dp1[n]=0;
        for (int k=n-1;k>=0;k--){
            int option1=cost.get(0)+dp1[k+1];
            int i=0;
            for ( i=k;i<n && days.get(i)< days.get(k)+7;i++);
            int option2=cost.get(1)+dp1[i];
            for ( i=k;i<n && days.get(i)< days.get(k)+30;i++);
            int option3=cost.get(2)+dp1[i];
            dp1[k]=Math.min(option1,Math.min(option2,option3));
        }
        return dp1[0];
    }
    public static int optimised(int n, Vector<Integer> days, Vector<Integer> cost){
        int ans=0;
        Queue<pair>month=new LinkedList<>();
        Queue<pair>week=new LinkedList<>();
        for (int day:days){
            while (!month.isEmpty()&&month.peek().days+30<=day){
                month.poll();
            }
            while (!week.isEmpty()&&week.peek().days+7<=day){
                week.poll();
            }
            week.add(new pair(day,ans+cost.get(1)));
            month.add(new pair(day,ans+cost.get(2)));
            ans=Math.min(ans+cost.get(0),Math.min(week.peek().costtill,month.peek().costtill));
        }
        return ans;
    }
}
