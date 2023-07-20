package DSA.GRAPH;

import java.util.*;

public class DIJKSTRAALGORITHIM {
    DIJKSTRAALGORITHIM(){

    }
   static class pair{
        int u;
        int w;
        pair(int u,int w){
            this.u=u;
            this.w=w;
        }
    }
    public static Vector<Integer> dijkstra(Vector<Vector<Integer>>vec,int vertices,int edges,int source){
        Map<Integer, ArrayList<pair>>map=new HashMap<>();
        for(int i=0;i<edges;i++){
            int u=vec.get(i).get(0);
            int v=vec.get(i).get(1);
            int w=vec.get(i).get(2);
           if (!map.containsKey(u)){
               map.put(u,new ArrayList<>());
           }
           map.get(u).add(new pair(v,w));
           if (!map.containsKey(v)){
               map.put(v,new ArrayList<>());
           }
           map.get(v).add(new pair(u,w));
        }
        Vector<Integer>distance=new Vector<>();
        for (int i=0;i<vertices;i++){
            distance.add(i,Integer.MAX_VALUE);
        }
        HashSet<pair>set=new HashSet<>();
        distance.add(source,0);
        set.add(new pair(source,0));
        while (!set.isEmpty()){
            Iterator<pair>iterator=set.iterator();
            pair p=iterator.next();
            set.remove(p);
            int node=p.u;
            int weight=p.w;
            for (pair re:map.get(node)){
                if (weight+ re.w<distance.get(re.u)){
                   boolean has= set.contains(new pair(re.u, re.w));
                   if (has){
                       set.remove(new pair(re.u, re.w));
                   }
                   distance.add(re.u,weight+ re.w);
                   set.add(new pair(re.u,distance.get(re.u)));
                }
            }
        }
        return distance;
    }
}
