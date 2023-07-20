package DSA.GRAPH;

import java.util.*;

public class CYCLEDETECTION {
    CYCLEDETECTION(){

    }
    public static String detectcycle(Vector<Vector<Integer>>edges,int n,int m){
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
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
        Map<Integer,Boolean>visited=new HashMap<>();
        for (int i=0;i<n;i++) {
            if (!visited.get(i)) {
                boolean ans=iscyclicbfs(map,visited,i);
                boolean ans1=iscyclicdfs(map,visited,i,-1);
                if (ans&&ans1){
                    return "yes";
                }
            }
        }
        return "no";
    }

    public static boolean iscyclicdfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited, int i,int parent) {
        visited.put(i,true);
        for (int v:map.get(i)){
            if (!visited.get(v)){
               boolean cyclic= iscyclicdfs(map, visited, v,i);
               if (cyclic){
                   return true;
               }
            }
            if ( v!=parent ){
                return true;
            }
        }
        return false;
    }

    public static boolean iscyclicbfs(Map<Integer, ArrayList<Integer>> map, Map<Integer, Boolean> visited, int i) {
        Map<Integer,Integer>parent=new HashMap<>();
        parent.put(i,-1);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        visited.put(i,true);
        while (!queue.isEmpty()) {
            int front = queue.peek();
            queue.poll();
            for (int node:map.get(front)) {
                if (visited.get(node) && node!=parent.get(front)) {
                    return true;
                }
                else {
                    queue.add(node);
                    visited.put(node, true);
                    parent.put(node,front);
                }
            }
        }
        return false;
    }
}
