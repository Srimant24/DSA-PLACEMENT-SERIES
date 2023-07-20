package DSA.GRAPH;

import java.util.*;

public class TOPOLOGICALSORTUSINGDFS {
    TOPOLOGICALSORTUSINGDFS(){

    }
    public static Vector<Integer>topologicalsort(Vector<Vector<Integer>>edges,int V,int e) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Map<Integer,Boolean>visited=new HashMap<>();
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
        }
        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<V;i++){
            if (!visited.get(i)){
                toposort(map,i,visited,stack);
            }
        }
        Vector<Integer>ans=new Vector<>();
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

    public static void toposort(Map<Integer, ArrayList<Integer>> map, int i, Map<Integer, Boolean> visited, Stack<Integer> stack) {
        visited.put(i,true);
        for (int n:map.get(i)){
            if (!visited.get(n)){
                toposort(map, n, visited, stack);
            }
        }
        stack.push(i);
    }
}
