package DSA.BINARYTREE;

import java.util.*;

public class TOPVIEW {
    TOPVIEW(){

    }
    static class NODE9 {
        int value;
        NODE9 left;
        NODE9 right;

        public NODE9(int value) {

            this.value = value;
        }

    }
    public NODE9 root;

    class pair {
        NODE9 node;
        NODE9 first;
        int hd;
        int second;
        pair(NODE9 node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public ArrayList Topv(NODE9 node){
        ArrayList<Integer>list=new ArrayList<>();
        if(node==null){
            return list;
        }
        Map<Integer,Integer>map=new IdentityHashMap<>();
        Queue<pair>queue=new LinkedList<>();
        queue.add(new pair(node, 0));
        while(!queue.isEmpty()){
            pair p = queue.peek();
            NODE9 peek=p.first;
            int hd = p.second;
            queue.remove();
            if (!map.containsKey(hd)){
                map.put(hd,peek.value);
            }
            if (peek.left!=null){
                queue.add(new pair(peek.left,hd-1));
            }
            if (peek.right!=null){
                queue.add(new pair(peek.right,hd+1));
            }
        }
        for (Map.Entry<Integer,Integer>entry:map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
