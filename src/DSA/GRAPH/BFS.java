package DSA.GRAPH;

import java.util.*;

public class BFS {
    BFS(){

    }
    class pair{
        int u;
        int v;
    }
    Map<Integer,ArrayList<Integer>>map=new HashMap<>();
    public static void prepareadjlist(Map<Integer, ArrayList<Integer>> map, Vector<pair> edges) {
        for (int i=0;i< edges.size();i++) {
            int u=edges.get(i).u;
            int v=edges.get(i).v;
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
    }
    public Vector BFS(int vertex,Vector<pair>edges){
        Vector<Integer>ans=new Vector<>();
        prepareadjlist(map,edges);
        Map<Integer,Boolean>visited=new HashMap<>();
        for (int i=-0;i<vertex;i++){
            if (!visited.get(i)){
                bfs(map,visited,ans,i);
            }
        }
        return ans;
    }

    public void bfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited, Vector<Integer> ans, int i) {
        Queue<Integer>queue=new LinkedList<>();
        queue.add(i);
        visited.put(i,true);
        while (!queue.isEmpty()){
            int front=queue.poll();
            ans.add(front);
            for (int node:map.get(front)) {
                if (!visited.get(node)) {
                    queue.add(node);
                    visited.put(node, true);
                }
            }
        }
    }
}
