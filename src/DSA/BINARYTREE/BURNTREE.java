package DSA.BINARYTREE;

import java.util.*;

public class BURNTREE {
    BURNTREE() {

    }

    static class NODE19 {
        int value;
        NODE19 left;
        NODE19 right;

        public NODE19(int value) {

            this.value = value;
        }

    }

    public NODE19 root;

    public int mintime(NODE19 node, int target) {
        Map<NODE19, NODE19> map = new HashMap<>();
        NODE19 node1 = nodeparentmapping(node, target, map);
        int ans=burntree(node1, map);
        return ans;
    }

    public int burntree(NODE19 node, Map<NODE19, NODE19> map) {
        Map<NODE19, Boolean> visited = new HashMap<>();
        Queue<NODE19> q = new LinkedList<>();
        q.add(node);
        visited.put(node, true);
        int ans = 0;
        while (!q.isEmpty()) {
            boolean flag = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NODE19 peek = q.peek();
                q.remove();
                if (peek.left != null && !visited.containsKey(peek)) {
                    flag = true;
                    q.add(node.left);
                    visited.put(node.left, true);
                }
                if (peek.right != null && !visited.containsKey(peek)) {
                    flag = true;
                    q.add(node.right);
                    visited.put(node.right, true);
                }
                if (!map.containsKey(peek) && !visited.containsKey(peek)) {
                    flag = true;
                    q.add(map.get(peek));
                    visited.put(map.get(peek), true);
                }
                if (flag == true) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public NODE19 nodeparentmapping(NODE19 node, int target, Map<NODE19, NODE19> map) {
        NODE19 res = null;
        Queue<NODE19> queue = new LinkedList<>();
        queue.add(node);
        map.put(null, node);
        while (!queue.isEmpty()) {
            NODE19 peek = queue.peek();
            queue.remove();
            if (peek.value == target) {
                res = peek;
            }
            if (peek.left != null) {
                map.put(node.left, node);
                queue.add(node.left);
            }
            if (peek.right != null) {
                map.put(node.right, node);
                queue.add(node.right);
            }
        }
        return res;
    }
}