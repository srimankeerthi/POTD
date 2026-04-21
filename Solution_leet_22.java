import java.util.*;

class Solution_leet_22 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        // 1. Group indices that can be swapped
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // 2. Map each component (root) to the multiset of values it contains in 'source'
        Map<Integer, Map<Integer, Integer>> componentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            componentMap.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> counts = componentMap.get(root);
            counts.put(source[i], counts.getOrDefault(source[i], 0) + 1);
        }

        // 3. For each index in 'target', check if its component has the required value
        int hammingDistance = 0;
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> counts = componentMap.get(root);
            int targetVal = target[i];

            if (counts.getOrDefault(targetVal, 0) > 0) {
                // We found a match in the allowed component
                counts.put(targetVal, counts.get(targetVal) - 1);
            } else {
                // No match available for this position
                hammingDistance++;
            }
        }

        return hammingDistance;
    }

    // Standard Union-Find helper class
    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) parent[rootI] = rootJ;
        }
    }
}
