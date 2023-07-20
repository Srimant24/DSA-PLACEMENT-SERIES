package DSA.BINARYTREE;

import java.util.*;

public class RIGHTVIEW {
    RIGHTVIEW(){

    }
    static class NODE12 {
        int value;
        NODE12 left;
        NODE12 right;

        public NODE12(int value) {

            this.value = value;
        }

    }
    public NODE12 root;

    class pair {
        NODE12 node;
        NODE12 first;
        int lvl;
        int second;
        pair(NODE12 node, int lvl){
            this.node=node;
            this.lvl=lvl;
        }
    }
    public ArrayList Topv(NODE12 node){
        ArrayList<Integer>list=new ArrayList<>();
        if(node==null){
            return list;
        }
        Map<Integer,Integer> map=new IdentityHashMap<>();
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(node, 0));
        while(!queue.isEmpty()){
            pair p = queue.peek();
            NODE12 peek=p.first;
            int lvl = p.second;
            queue.remove();
            
            map.put(lvl,peek.value);

            if (peek.left!=null){
                queue.add(new pair(peek.left,lvl+1));
            }
            if (peek.right!=null){
                queue.add(new pair(peek.right,lvl+1));
            }
        }
        for (Map.Entry<Integer,Integer>entry:map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}
