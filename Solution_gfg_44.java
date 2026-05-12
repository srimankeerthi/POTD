class Solution_gfg_44 {
    long[] tree;
    int n;

    // Helper function to find GCD
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Helper function to find LCM
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Using formula: (a*b)/gcd(a,b)
        return (a / gcd(a, b)) * b; 
    }

    // Build the Segment Tree
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = (long) arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    // Update the Segment Tree
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = (long) val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, val);
        else update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = lcm(tree[2 * node], tree[2 * node + 1]);
    }

    // Query the LCM in range [L, R]
    private long query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) return 1; 
        if (L <= start && end <= R) return tree[node];
        
        int mid = (start + end) / 2;
        long leftLcm = query(2 * node, start, mid, L, R);
        long rightLcm = query(2 * node + 1, mid + 1, end, L, R);
        return lcm(leftLcm, rightLcm);
    }

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        // FIXED: Changed .size() to .length
        n = arr.length; 
        tree = new long[4 * n];
        ArrayList<Long> result = new ArrayList<>();
        
        build(arr, 1, 0, n - 1);

        for (int[] q : queries) {
            if (q[0] == 1) {
                // Update Query: [1, index, value]
                update(1, 0, n - 1, q[1], q[2]);
            } else {
                // Range Query: [2, L, R]
                result.add(query(1, 0, n - 1, q[1], q[2]));
            }
        }
        return result;
    }
}
