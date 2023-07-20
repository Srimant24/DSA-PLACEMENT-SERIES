package DSA.GREEDY;

// Java code for the above approach

import java.util.*;

public class JOB {

    // Each job has a unique-id,profit and deadline
    int id;
    int deadline, profit;

    // Constructors
    public JOB() {}

    public JOB(int id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }


    public static Vector<Integer> printJobScheduling(ArrayList<JOB> arr)
    {
        int n = arr.size();
        Collections.sort(arr,
                (a, b) -> b.profit - a.profit);

       int maxdeadline=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxdeadline=Math.max(maxdeadline,arr.get(i).deadline);
        }
        Vector<Integer>deadline=new Vector<>(maxdeadline+1);
        for (int i=0;i<deadline.size();i++){
            deadline.add(-1);
        }
        int count=0;
        int maxpriofit=0;
        for (int i=0;i<n;i++){
            int id=arr.get(i).id;
            int currdeadline=arr.get(i).deadline;
            int profit=arr.get(i).profit;
            for (int k=currdeadline;k>0;k--){
                if (deadline.get(k)==-1){
                    deadline.add(k,id);
                    count++;
                    maxpriofit+=profit;
                }
            }
        }
        Vector<Integer>ans=new Vector<>();
        ans.add(count);
        ans.add(maxpriofit);
        return ans;
    }
}



