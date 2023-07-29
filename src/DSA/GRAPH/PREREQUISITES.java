package DSA.GRAPH;
import java.util.*;
public class PREREQUISITES {
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph.get(curr).size(); i++) {
            int neigh = graph.get(curr).get(i);
            if(stack[neigh] == true) {
                return true;
            }
            if(!vis[neigh] && dfs(graph, neigh, vis,
                    stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][]
            prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> graph = new
                ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            graph.get(u).add(v);
        }
        boolean vis[] = new boolean[n];
        boolean stack[] = new boolean[n];
        for(int i=0; i<n; i++) {
            boolean isCycle = dfs(graph, i, vis, stack);
            if(isCycle) {
                return false;
            }
        }
        return true;
    }
}
