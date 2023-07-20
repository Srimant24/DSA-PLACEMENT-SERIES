package DSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CYCLEDETECTIONINDIRECTEDGRAPHUSINGDFS {
    CYCLEDETECTIONINDIRECTEDGRAPHUSINGDFS(){

    }
    class pair{
        int u;
        int v;
    }
    public static String detect(int n, Vector<pair>edges){
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for (int i=0;i< edges.size();i++) {
            int u=edges.get(i).u;
            int v=edges.get(i).v;
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
        }
        Map<Integer,Boolean>visited=new HashMap<>();
        Map<Integer,Boolean>dfsvisited=new HashMap<>();
        for (int i=1;i<=n;i++){
            if (!visited.get(i)) {
                boolean ans=iscyclicdfs(map,visited,i,dfsvisited);
                if (ans){
                    return "yes";
                }
            }
        }
        return "no";
        }

    public static boolean iscyclicdfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited, int i, Map<Integer, Boolean> dfsvisited) {
        visited.put(i,true);
        dfsvisited.put(i,true);
        for (int v:map.get(i)){
            if (!visited.get(v)){
              boolean cyclic=  iscyclicdfs(map, visited, v, dfsvisited);
              if (cyclic){
                  return true;
              }
            }
            else if(dfsvisited.get(v)) {
                return true;
            }
        }
        dfsvisited.put(i,false);
        return false;
    }
}

