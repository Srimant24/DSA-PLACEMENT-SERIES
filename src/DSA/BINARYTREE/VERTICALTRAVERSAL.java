package DSA.BINARYTREE;


import java.security.Key;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class VERTICALTRAVERSAL {
    VERTICALTRAVERSAL(){

    }
    static class NODE8 {
        int value;
        NODE8 left;
        NODE8 right;

        public NODE8(int value) {

            this.value = value;
        }

    }
    public NODE8 root;

    public void verticalordertraversal(NODE8 node){
        TreeMap<Integer, Vector<Integer>>map = null;
        int hd=0;
        VOT(node,hd,map);
        for (Map.Entry<Integer,Vector<Integer>> entry:map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private void VOT(NODE8 node, int hd, TreeMap<Integer, Vector<Integer>> map) {
        if (node==null){
            return;
        }
        Vector<Integer>get=map.get(hd);
        if (get==null){
            get = new Vector<>();
            get.add(node.value);
        }
        get.add(node.value);
        map.put(hd,get);
        VOT(node.left,hd-1,map);
        VOT(node.right,hd+1,map);
    }
}
