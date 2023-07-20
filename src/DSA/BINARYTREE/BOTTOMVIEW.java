package DSA.BINARYTREE;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class BOTTOMVIEW {
    BOTTOMVIEW(){

    }
        static class NODE10 {
            int value;
            NODE10 left;
            NODE10 right;

            public NODE10(int value) {

                this.value = value;
            }

        }
        public NODE10 root;

        class pair {
            NODE10 node;
            NODE10 first;
            int hd;
            int second;
            pair(NODE10 node, int hd){
                this.node=node;
                this.hd=hd;
            }
        }
        public ArrayList BOTTOMV(NODE10 node){
            ArrayList<Integer>list=new ArrayList<>();
            if(node==null){
                return list;
            }
            Map<Integer,Integer> map=null;
            Queue<pair> queue=null;
            queue.add(new pair(node, 0));
            while(!queue.isEmpty()){
               pair p = queue.peek();
               NODE10 peek=p.first;
                int hd = p.second;
                queue.remove();
                map.put(hd,peek.value);
                if (node.left!=null){
                    queue.add(new pair(node.left,hd-1));
                }
                if (node.right!=null){
                    queue.add(new pair(node.right,hd+1));
                }
            }
            for (Map.Entry<Integer,Integer>entry:map.entrySet()) {
                list.add(entry.getValue());
            }
            return list;
        }
    }

