class Solution_gfg_13 {
    // Renamed from countIncreasingSubarrays to countIncreasing to fix the error
    public long countIncreasing(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;

        long totalCount = 0;
        long currentLen = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                currentLen++;
            } else {
                if (currentLen >= 2) {
                    totalCount += (currentLen * (currentLen - 1)) / 2;
                }
                currentLen = 1; 
            }
        }

        // Final check for the last segment
        if (currentLen >= 2) {
            totalCount += (currentLen * (currentLen - 1)) / 2;
        }

        return totalCount;
    }
}
