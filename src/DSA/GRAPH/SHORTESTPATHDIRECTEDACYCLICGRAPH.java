package DSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SHORTESTPATHDIRECTEDACYCLICGRAPH {
    SHORTESTPATHDIRECTEDACYCLICGRAPH(){

    }
   static class pair{
        int u;
        int w;
        pair(int u,int w){
            this.u=u;
            this.w=w;
        }
    }
    static Map<Integer, ArrayList<pair>>map=new HashMap<>();
    static Map<Integer,Boolean>visited=new HashMap<>();
     static int n=6;
    public static void addegge(int u,int v,int weight){
        pair p=new pair(v,weight);
        if (!map.containsKey(u)){
            map.put(u,new ArrayList<>());
        }
        map.get(u).add(p);

        Stack<Integer>stack=new Stack<>();
        for (int i=0;i<n;i++){
            if (!visited.get(i)){
                dfs(i,visited,map,stack);
            }
        }
    }
    public static void shortestpath(Stack<Integer> stack){
        int[] distance=new int[n+1];
        int src=1;
        for (int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;
        while (!stack.isEmpty()){
            int top=stack.pop();
            if (distance[top]!=Integer.MAX_VALUE){
                for (pair v:map.get(top)){
                  if (distance[top]+v.w<distance[v.u]){
                      distance[v.u]=distance[top]+v.w;
                  }
                }
            }
        }
        for (int i=0;i< distance.length;i++){
            System.out.println(distance[i]);
        }
    }

    public static void dfs(int i, Map<Integer, Boolean> visited, Map<Integer, ArrayList<pair>> map, Stack<Integer> stack) {
        visited.put(i,true);
        for (pair v:map.get(i)){
            if (!visited.get(v.u)){
                dfs(v.u, visited, map, stack);
            }
        }
        stack.push(i);
    }

}
