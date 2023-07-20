package DSA.GRAPH;

import java.util.*;

public class SHORTESTPATHUNDIRECTEDGRAPH {
    SHORTESTPATHUNDIRECTEDGRAPH(){

    }
    class pair{
        int u;
        int v;
    }
    public static Vector<Integer>shortestpath(Vector<pair>edges,int n,int m,int s,int t){
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
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
        Map<Integer,Boolean>visited=new HashMap<>();
        Map<Integer,Integer>parent=new HashMap<>();
        Queue<Integer>quee=new LinkedList<>();
        quee.add(s);
        parent.put(s,-1);
        visited.put(s,true);
        while (!quee.isEmpty()){
            int front= quee.poll();
            for (int v:map.get(front)){
                if (!visited.get(v)){
                    visited.put(v,true);
                    parent.put(v,front);
                    quee.add(v);
                }
            }
        }
        Vector<Integer>ans=new Vector<>();
        Vector<Integer>finalans=new Vector<>();
        int currentnode=t;
        ans.add(t);
        while (currentnode!=s){
            currentnode=parent.get(currentnode);
            ans.add(currentnode);
        }
        for (int i= ans.size()-1;i>=0;i--){
            finalans.add(ans.get(i));
        }
        return finalans;
    }
}

