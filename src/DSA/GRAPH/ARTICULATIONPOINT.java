package DSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class ARTICULATIONPOINT {
    ARTICULATIONPOINT(){

    }
   static class pair{
        int u;
        int v;
        pair(int u,int v){
            this.u=u;
            this.v=v;
        }
    }
    public static void dfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited,
                           int i, int parent, int timer, Vector<Integer> disc, Vector<Integer> lowest, Vector<Integer> ap) {
        visited.put(i,true);
        disc.set(i,timer++);
        lowest.set(i,timer++);
        int child=0;
        for (int v:map.get(i)){
            if (v==parent){
                continue;
            }
            if (!visited.get(v)){
                dfs(map, visited, v, i, timer, disc, lowest, ap);
                lowest.set(i,Math.min(lowest.get(i),lowest.get(v)));
                if (lowest.get(v) >= disc.get(i)&&parent!=-1) {
                    ap.add(i,1);
                }
                child++;
            }
            else {
                lowest.set(i,Math.min(disc.get(v),lowest.get(i)));
            }
        }
        if (parent==-1&&child>1){
            ap.set(i,1);
        }
    }

    public static void main(String[] args) {
        int n=5;
        int e=5;
        Vector<pair>edges=new Vector<>();
        edges.add(new pair(0,3));
        edges.add(new pair(3,4));
        edges.add(new pair(0,4));
        edges.add(new pair(0,1));
        edges.add(new pair(1,2));
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        for (int i =0;i< edges.size();i++){
            int U=edges.get(i).u;
            int V=edges.get(i).v;

            if (!map.containsKey(U)) {
                map.put(U, new ArrayList<>());
            }
            map.get(U).add(V);
            if (!map.containsKey(V)) {
                map.put(V, new ArrayList<>());
            }
            map.get(V).add(U);
        }
        Vector<Integer>ap=new Vector<>();
        for (int i=0;i< n;i++){
            ap.add(i,0);
        }
        int timer=0;
        Vector<Integer>disc=new Vector<>();
        Vector<Integer>lowest=new Vector<>();
        int parent=-1;
        Map<Integer,Boolean>visited=new HashMap<>();
        for (int i=0;i<n;i++){
            disc.add(i,-1);
            lowest.add(i,-1);
            visited.put(i,false);
        }
        for (int i=0;i<n;i++){
            if (!visited.get(i)){
                dfs(map,visited,i,parent,timer,disc,lowest,ap);
            }
        }
        for (int i=0;i< n;i++){
            if (ap.get(i)!=0){
                System.out.println(i);
            }
        }
    }
}
