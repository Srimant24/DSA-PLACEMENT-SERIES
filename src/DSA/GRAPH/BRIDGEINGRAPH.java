package DSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BRIDGEINGRAPH {
    BRIDGEINGRAPH(){

    }
    public static Vector<Vector<Integer>> findbridges(Vector<Vector<Integer>>edges,int V,int e){
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
        int timer=0;
        Vector<Integer>disc=new Vector<>();
        Vector<Integer>lowest=new Vector<>();
        int parent=-1;
        Map<Integer,Boolean>visited=new HashMap<>();
        for (int i=0;i<V;i++){
            disc.add(i,-1);
            lowest.add(i,-1);
        }
        Vector<Vector<Integer>>result=new Vector<>();
        for (int i=0;i<V;i++){
            if (!visited.get(i)){
                dfs(map,visited,i,parent,timer,disc,lowest,result);
            }
        }
        return result;
    }

    public static void dfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited,
                           int i, int parent, int timer, Vector<Integer> disc, Vector<Integer> lowest, Vector<Vector<Integer>> result) {
        visited.put(i,true);
        disc.set(i,timer++);
        lowest.set(i,timer++);
        for (int v:map.get(i)){
            if (v==parent){
                continue;
            }
            if (!visited.get(v)){
                dfs(map, visited, v, i, timer, disc, lowest, result);
                lowest.set(i,Math.min(lowest.get(i),lowest.get(v)));
                if (lowest.get(v) > disc.get(i)) {
                    Vector<Integer>ans = null;
                    ans.add(i);
                    ans.add(v);
                    result.add(ans);
                }
            }
            else {
                lowest.set(i,Math.min(disc.get(v),lowest.get(i)));
            }
        }
    }
}
