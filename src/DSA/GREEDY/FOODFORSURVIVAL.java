package DSA.GREEDY;

public class FOODFORSURVIVAL {
    FOODFORSURVIVAL(){

    }
    public static int minmumdays(int s,int n,int m){
        int sunday=s/7;
        int buyingdays=s-sunday;
        int total=s*m;
        int ans=0;
        if (total%n==0){
            ans=total/n;
        }else {
            ans=total/n+1;
        }
        if (ans<=buyingdays){
            return ans;
        }
        else {
            return -1;
        }
    }
}
