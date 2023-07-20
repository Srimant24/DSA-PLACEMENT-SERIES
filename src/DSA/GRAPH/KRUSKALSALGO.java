package DSA.GRAPH;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class KRUSKALSALGO {
    KRUSKALSALGO(){

    }
    public static int mst(Vector<Vector<Integer>>edges,int n){
        Vector<Integer>parent=new Vector<>(n);
        Vector<Integer>rank=new Vector<>(n);
        makeparent(parent,rank,n);
        int minweight=0;
        Collections.sort(edges, new Comparator<Vector<Integer>>() {
            public int compare(Vector<Integer> edge1, Vector<Integer> edge2) {
                int weight1 = edge1.get(2);
                int weight2 = edge2.get(2);

                if (weight1 < weight2) {
                    return -1; // edge1 comes before edge2
                } else if (weight1 > weight2) {
                    return 1; // edge1 comes after edge2
                } else {
                    return 0; // weights are equal
                }
            }
        });
        for (int i=0;i< edges.size();i++){
            int u=findparent(parent,edges.get(i).get(0));
            int v=findparent(parent,edges.get(i).get(1));
            int weight=edges.get(i).get(2);
            if (u!=v){
                minweight+=weight;
                union(parent,rank,u,v);
            }
        }
        return minweight;
    }

    public static void makeparent(Vector<Integer> parent, Vector<Integer> rank, int n) {
        for (int i=0;i<n;i++){
            parent.add(i,i);
            rank.add(i,0);
        }
    }
    public static int findparent(Vector<Integer> parent, int node) {
        if (parent.get(node)==node){
            return node;
        }
        return parent.set(node,findparent(parent,parent.get(node)));
    }
    public static void union(Vector<Integer> parent,Vector<Integer>rank, int u,int v){
        u=findparent(parent,u);
        v=findparent(parent,v);
        if (rank.get(u)<rank.get(v)){
            parent.set(u,v);
        } else if (rank.get(v)<rank.get(u)) {
            parent.set(v,u);
        }else {
            parent.set(v,u);
            rank.set(u,rank.get(u)+1);
        }
       
    }
}
