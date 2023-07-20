package DSA.DPSERIES;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class MAXHEIGHTOFSTACKCUBOID {
    MAXHEIGHTOFSTACKCUBOID(){

    }
    public static int optimised(int n,Vector<Vector<Integer>>a){
        int[] next=new int[n+1];
        for (int i=0;i<n;i++){
            next[i]=0;
        }
        int[] curr=new int[n+1];
        for (int i=0;i<n;i++){
            curr[i]=0;
        }

        for (int i=n-1;i>=0;i--){
            for (int j=i-1;j>=-1;j--){
                int take=0;
                if (j==-1 || check(a.get(i),a.get(j))){
                    take=a.get(i).get(2)+next[i+1];
                }
                int notake=next[j];
                curr[j+1]=Math.max(take,notake);
            }
            next=curr;
        }
        return next[0];
    }
    public static int maxheight(Vector<Vector<Integer>>cuboids){
        for (Vector<Integer>vector:cuboids) {
            Collections.sort(vector);
        }
        Collections.sort(cuboids, new Comparator<Vector<Integer>>() {
            @Override
            public int compare(Vector<Integer> v1, Vector<Integer> v2) {

                return v1.get(0).compareTo(v2.get(0));
            }
        });
       return optimised(cuboids.size(),cuboids);
    }
    public static boolean check(Vector<Integer> v1,Vector<Integer> v2){
        if (v2.get(0)<=v1.get(0)&&v2.get(1)<=v1.get(1)&&v2.get(2)<=v1.get(2)){
            return true;
        }else {
            return false;
        }
    }
}
