package DSA.GRAPH;

import java.util.Vector;

public class BELLMANFORDALGORITHIM {
    BELLMANFORDALGORITHIM(){

    }
    public static int bellmanford(int n, int m, int src, int dest, Vector<Vector<Integer>>edges){
        Vector<Integer>distance=new Vector<>(n+1);
        for (int i= 0;i<=n;i++){
            distance.add(i,Integer.MAX_VALUE);
        }
        distance.set(src,0);
        for (int i=1;i<=n-1;i++){
            for (int j=0;j<m;j++){
                int u=edges.get(j).get(0);
                int v=edges.get(j).get(1);
                int w=edges.get(j).get(2);
                if (distance.get(u)+w<distance.get(v)&&distance.get(u)!=Integer.MAX_VALUE){
                    distance.set(v,distance.get(u)+w);
                }
            }
        }
        boolean flag=false;
        for (int i=1;i<=n;i++){
            for (int j=0;j<m;j++){
                int u=edges.get(j).get(0);
                int v=edges.get(j).get(1);
                int w=edges.get(j).get(2);
                if (distance.get(u)+w<distance.get(v)&&distance.get(u)!=Integer.MAX_VALUE){
                    distance.set(v,distance.get(u)+w);
                    flag=true;
                }
            }
        }
        if (flag==true){
            System.out.println("-ve cycle is present");
            return -1;
        }
        else {
            return distance.get(dest);
        }
    }
}
