class Solution_gfg_23{
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] prefixSum = new long[n];
        ArrayList<Integer> result = new ArrayList<>();

        // 1. Build the Prefix Sum array
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 2. Process each query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            long rangeSum;
            if (l == 0) {
                rangeSum = prefixSum[r];
            } else {
                rangeSum = prefixSum[r] - prefixSum[l - 1];
            }

            int count = r - l + 1;
            // 3. Compute floor mean using integer division
            int mean = (int) (rangeSum / count);
            result.add(mean);
        }

        return result;
    }
}
