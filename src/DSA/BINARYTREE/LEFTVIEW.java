package DSA.BINARYTREE;

import java.util.*;

public class LEFTVIEW {
    LEFTVIEW(){

    }
    static class NODE11 {
        int value;
        NODE11 left;
        NODE11 right;

        public NODE11(int value) {

            this.value = value;
        }

    }
    public NODE11 root;

    class pair {
        NODE11 node;
        NODE11 first;
        int lvl;
        int second;
        pair(NODE11 node, int lvl){
            this.node=node;
            this.lvl=lvl;
        }
    }
    public ArrayList Topv(NODE11 node){
        ArrayList<Integer>list=new ArrayList<>();
        if(node==null){
            return list;
        }
        Map<Integer,Integer> map=new IdentityHashMap<>();
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(node, 0));
        while(!queue.isEmpty()){
            pair p = queue.peek();
            NODE11 peek=p.first;
            int lvl = p.second;
            queue.remove();
            if (!map.containsKey(lvl)){
                map.put(lvl,peek.value);
            }
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

