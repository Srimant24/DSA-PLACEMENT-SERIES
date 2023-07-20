package DSA.GRAPH;

import java.util.*;

public class TOPOLOGICALSORTUSINGBFS {
    TOPOLOGICALSORTUSINGBFS(){

    }
    public static Vector<Integer>topologicalsorting(Vector<Vector<Integer>>edges,int V){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
        }
        Vector<Integer>indegree=new Vector<>();
        for (int i=0;i< indegree.size();i++){
            indegree.add(i,0);
        }
       for (Map.Entry<Integer,ArrayList<Integer>>entry:map.entrySet()){
           int u= entry.getKey();
           ArrayList<Integer>list=entry.getValue();
           for (int v:list){
               indegree.add(v, indegree.get(v)+1);
           }
       }
        Queue<Integer>queue=new LinkedList<>();
       for (int i=0;i<V;i++){
           if (indegree.get(i)==0){
               queue.add(i);
           }
       }
       Vector<Integer>ans=new Vector<>();
       while (!queue.isEmpty()){
           int front=queue.poll();
           ans.add(front);
           for (int v:map.get(front)){
               indegree.add(v, indegree.get(v)-1);
               if (indegree.get(v)==0){
                   queue.add(v);
               }
           }
       }
       return ans;
    }
}
