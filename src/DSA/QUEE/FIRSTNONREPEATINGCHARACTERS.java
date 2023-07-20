package DSA.QUEE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FIRSTNONREPEATINGCHARACTERS {
    public static String firstnonrepeating(String str){
        Map<Character,Integer>map=new HashMap<>();
        Queue<Character>queue=new LinkedList<>();
        String ans="";
        for (int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if (map.containsKey(curr)){
                map.put(curr, map.get(curr)+1);
                queue.add(curr);
            }else {
                map.put(curr,1);
                queue.add(curr);
            }
            while (!queue.isEmpty()){
                if (map.get(queue.peek())>1){
                    queue.poll();
                }
                else {
                    ans+=queue.peek();
                    break;
                }
            }
            if (queue.isEmpty()) {
                ans += "#";
            }
        }
        return ans;
    }
}
