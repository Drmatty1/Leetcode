import java.util.*;

class Solution {
    class DSU {
        int[] par;

        DSU(int n) {
            par = new int[n];
            for (int i = 0; i < n; i++) par[i] = i;
        }

        int find(int i) {
            if (i == par[i]) return i;
            return par[i] = find(par[i]);
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) {
                par[pb] = pa;
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);

        for (List<Integer> p : pairs) {
            dsu.union(p.get(0), p.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        StringBuilder ans = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            ans.append(map.get(root).poll());
        }

        return ans.toString();
    }
}