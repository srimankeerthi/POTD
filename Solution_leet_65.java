import java.util.*;

class Solution_leet_65{
    // Segment Tree to store the maximum gap in a coordinate range
    int[] tree;
    int maxCoord;

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2 * node + 1, mid + 1, end, l, r);
        return Math.max(p1, p2);
    }

    public List<Boolean> getResults(int[][] queries) {
        // Determine the maximum coordinate bounding box dynamically
        maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        // Safely bound maxCoord to prevent excessive segment tree allocation
        maxCoord = Math.max(maxCoord, 50000);

        tree = new int[4 * (maxCoord + 1)];
        
        // TreeSet tracking obstacle positions. 
        // Initialize with 0 and a virtual boundary at infinity to avoid null checks.
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(Integer.MAX_VALUE);

        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            if (type == 1) {
                int x = q[1];
                int prev = obstacles.lower(x);
                int next = obstacles.higher(x);

                obstacles.add(x);
                
                // Update the gap for the newly placed obstacle
                update(1, 0, maxCoord, x, x - prev);
                
                // Update the gap for the next obstacle if it falls within our tracked segment tree range
                if (next != Integer.MAX_VALUE && next <= maxCoord) {
                    update(1, 0, maxCoord, next, next - x);
                }
            } else {
                int x = q[1];
                int sz = q[2];

                // Find the largest obstacle strictly less than or equal to x
                int prev = obstacles.floor(x);

                // 1. Max gap completely to the left of the 'prev' obstacle
                int maxGapLeft = query(1, 0, maxCoord, 0, prev);
                
                // 2. The remaining trailing gap between 'prev' and 'x'
                int trailingGap = x - prev;

                int maxAvailableGap = Math.max(maxGapLeft, trailingGap);

                results.add(maxAvailableGap >= sz);
            }
        }

        return results;
    }
}
