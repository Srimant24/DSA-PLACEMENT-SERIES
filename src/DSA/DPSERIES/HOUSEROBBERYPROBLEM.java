package DSA.DPSERIES;

import java.util.Vector;

public class HOUSEROBBERYPROBLEM {
    HOUSEROBBERYPROBLEM(){

    }

    public static int houserobber(Vector<Integer>valueinhouse){
        int n= valueinhouse.size();;
        if (n==1){
            return valueinhouse.get(1);
        }
        Vector<Integer>first=new Vector<>();
        Vector<Integer>second=new Vector<>();
        for (int i=0;i<n;i++){
            if (i!=n-1){
                first.add(valueinhouse.get(i));
            }
            if (i!=0){
                second.add(valueinhouse.get(i));
            }
        }
        return Math.max(optimise(first),optimise(second));
    }
    public static int optimise(Vector<Integer>house){
        int a=0;
        int b=house.get(0);
        for (int i=1;i< house.size();i++){
            int temp=b;
            int include=b+house.get(i);
            int exclude=a;
            int ans=Math.max(include,exclude);
            b=ans;
            a=temp;
        }
        return b;
    }
}
