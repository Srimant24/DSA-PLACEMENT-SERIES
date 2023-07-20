package DSA.GRAPH;

import java.util.*;

public class DFS {
    DFS(){

    }
    public static Vector<Vector<Integer>> depthfs(int V,int e,Vector<Vector<Integer>>edges){
        Map<Integer, ArrayList<Integer>>map=new HashMap<>();
        for (int i =0;i< edges.size();i++){
            int u=edges.get(i).get(0);
            int v=edges.get(i).get(1);

            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
        Vector<Vector<Integer>>ans=new Vector<>();
        Map<Integer,Boolean>visited=new HashMap<>();
        for (int i=0;i<V;i++){
            if (!visited.get(i)){
                Vector<Integer>com=new Vector<>();
                dfs(map,visited,com,i);
                ans.add(com);
            }
        }
        return ans;
    }

    public static void dfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited, Vector<Integer>com, int i) {
        com.add(i);
        visited.put(i,true);
        for (int v: map.get(i)){
            if (!visited.get(v)){
                dfs(map, visited, com, v);
            }
        }
    }
}
