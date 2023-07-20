package DSA.GREEDY;

import java.util.Arrays;
import java.util.Comparator;

public class ACTIVITYSELECTIONPROBLEM {
    ACTIVITYSELECTIONPROBLEM(){

    }
    static class pair{
        int start;
        int end;
        pair(int start,int end){
            this.start=start;
            this.end=end;
        }
        public int getStart() {
            return start;
        }

        public int getEnd() {

            return end;
        }

    }
    public static int maxmeetings(int[] st,int[] en,int n){
        pair[] arr=new pair[n];
        int[] no=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=new pair(st[i],en[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(pair::getEnd));
        int count=1;
        int ansend=arr[0].end;
        for (int i=1;i<n;i++){
            if (arr[i].start>ansend){
                count++;
                ansend=arr[i].end;
                no[i]=i;
            }
        }
        System.out.println(Arrays.toString(no));
        return count;
    }
}
