class Solution_leet_36 {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] ans = new int[n];

        // 1. Calculate Prefix Maximums
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // 2. Calculate Suffix Minimums
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        // 3. Identify blocks and fill the answer
        // A block ends when prefixMax[i] <= suffixMin[i+1]
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (right == n - 1 || prefixMax[right] <= suffixMin[right + 1]) {
                // Find the max in the current block [left, right]
                int currentBlockMax = 0;
                for (int k = left; k <= right; k++) {
                    currentBlockMax = Math.max(currentBlockMax, nums[k]);
                }
                // Assign this max to all indices in the block
                for (int k = left; k <= right; k++) {
                    ans[k] = currentBlockMax;
                }
                left = right + 1;
            }
        }

        return ans;
    }
}
