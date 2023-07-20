package DSA.GRAPH;

import java.util.*;

public class CONNECTEDCOMPONENT {
    CONNECTEDCOMPONENT() {

    }

    public static void dfs(int i, Map<Integer, ArrayList<Integer>> map, Stack<Integer>stack,Map<Integer, Boolean> visited ) {
        visited.put(i,true);
        for (int v: map.get(i)){
            if (!visited.get(v)){
                dfs(v,map,visited);
            }
        }
        stack.push(i);
    }

    public static int connected(int v, Vector<Vector<Integer>> edges) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.size(); i++) {
            int U = edges.get(i).get(0);
            int V = edges.get(i).get(1);

            if (!map.containsKey(U)) {
                map.put(U, new ArrayList<>());
            }
            map.get(U).add(V);

        }
        Stack<Integer> stack = null;
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int i = 0; i < v; i++) {
            if (!visited.get(i)) {
                dfs(i, map, stack, visited);
            }
        }
        Map<Integer, ArrayList<Integer>> maptranspose=new HashMap<>();
        for (int i=0;i<v;i++){
            visited.put(i,false);
            for (int e:map.get(i)){
                if (!maptranspose.containsKey(e)) {
                    map.put(e, new ArrayList<>());
                }
                map.get(e).add(i);
            }
        }
        int count=0;
        while (!stack.isEmpty()){
            int top=stack.pop();
            if (!visited.get(top)){
                count++;
                dfs(top,maptranspose,visited);
            }
        }
        return count;
    }

    public static void dfs(int top, Map<Integer, ArrayList<Integer>> maptranspose, Map<Integer, Boolean> visited) {
        visited.put(top,true);
        for (int v: maptranspose.get(top)){
            if (!visited.get(v)){
                dfs(v,maptranspose,visited);
            }
        }
    }
}
