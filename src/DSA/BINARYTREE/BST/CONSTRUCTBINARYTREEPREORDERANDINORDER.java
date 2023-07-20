package DSA.BINARYTREE.BST;

import java.util.HashMap;
import java.util.Map;

public class CONSTRUCTBINARYTREEPREORDERANDINORDER {
    CONSTRUCTBINARYTREEPREORDERANDINORDER(){

    }
    static class NODE17 {
        int value;
        NODE17 left;
        NODE17 right;

        public NODE17(int value) {

            this.value = value;
        }

    }
    public NODE17 roote;

    public NODE17 CBT(int[] in,int[] pre,int n){
        Map<Integer,Integer>map=new HashMap<>();
        int preorderindex=0;
        findpos(in,map,n);
        NODE17 node = solve(in,pre,map,preorderindex,0,n-1,n);
        return node;
    }

    public NODE17 solve(int[] in, int[] pre,Map<Integer,Integer>map, int index, int start, int end, int n) {
        if (index>=n||start>end){
            return  null;
        }
        int element=pre[index++];
        NODE17 node=new NODE17(element);
       int pos=map.get(element);
       solve(in, pre,map, index, start, pos-1, n);
       solve(in, pre,map, index, pos+1, end, n);
       return node;
    }

    public void findpos(int[] in, Map<Integer, Integer> map, int n) {
        for (int i = 0; i < n; i++) {
            map.put(i, in[i]);
        }
    }
}
