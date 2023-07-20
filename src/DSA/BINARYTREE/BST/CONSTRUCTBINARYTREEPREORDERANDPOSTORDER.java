package DSA.BINARYTREE.BST;

import java.util.HashMap;
import java.util.Map;

public class CONSTRUCTBINARYTREEPREORDERANDPOSTORDER {
    CONSTRUCTBINARYTREEPREORDERANDPOSTORDER(){

    }
    static class NODE18 {
        int value;
        NODE18 left;
        NODE18 right;

        public NODE18(int value) {

            this.value = value;
        }

    }
    public NODE18 rooot;

    public NODE18 CBT(int[] in, int[] pre, int n){
        Map<Integer,Integer>map=new HashMap<>();
        findpos(in,map,n);
        int postorderindex=n-1;
        NODE18 node = solve(in,pre,map,postorderindex,0,n-1,n);
        return node;
    }

    public void findpos(int[] in, Map<Integer, Integer> map, int n) {
        for (int i = 0; i < n; i++) {
            map.put(i, in[i]);
        }
    }

    public NODE18 solve(int[] in,int[] pre,Map<Integer,Integer>map,int index, int start, int end, int n) {
        if (index>=n||start>end){
            return  null;
        }
        int element=pre[index--];
        NODE18 node=new NODE18(element);
        int pos=map.get(element);
        solve(in, pre,map, index, start, pos-1, n);
        solve(in, pre,map, index, pos+1, end, n);
        return node;
    }


}
