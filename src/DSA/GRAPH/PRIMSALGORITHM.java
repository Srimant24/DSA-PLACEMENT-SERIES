package DSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class PRIMSALGORITHM {
    PRIMSALGORITHM(){

    }
    static class pair1{
        int u;
        int w;
        pair1(int u,int w){
            this.u=u;
            this.w=w;
        }
    }
    public static Map<pair1,Integer> algo(Vector<Vector<Integer>>vec,int n){
        Map<Integer, ArrayList<pair1>> map=new HashMap<>();
        for(int i=0;i<vec.size();i++){
            int u=vec.get(i).get(0);
            int v=vec.get(i).get(1);
            int w=vec.get(i).get(2);
            if (!map.containsKey(u)){
                map.put(u,new ArrayList<>());
            }
            map.get(u).add(new pair1(v,w));
            if (!map.containsKey(v)){
                map.put(v,new ArrayList<>());
            }
            map.get(v).add(new pair1(u,w));
        }
        Vector<Integer>distance=new Vector<>(n+1);
        Vector<Boolean>mst=new Vector<>(n+1);
        Vector<Integer>parent=new Vector<>(n+1);
        for (int i=0;i<=n;i++){
            distance.add(i,Integer.MAX_VALUE);
            mst.add(i,false);
            parent.add(i,-1);
        }
        distance.set(1,0);
        parent.set(1,-1);
        for (int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            int u =0;
            for (int v=1;v<=n;v++){
                if (!mst.get(v)&&distance.get(v)<min){
                    u=v;
                    min=distance.get(v);
                }
            }
            mst.add(u,true);
            for(pair1 p:map.get(u)){
                int v=p.u;
                int w=p.w;
                if (!mst.get(v)&&w<distance.get(v)){
                    parent.set(v,u);
                    distance.set(v,w);
                }
            }
        }
        Map<pair1,Integer>ans=new HashMap<>();
        for (int i=2;i<=n;i++){
            ans.put(new pair1(parent.get(i),i),distance.get(i));
        }
        return ans;
    }
}
