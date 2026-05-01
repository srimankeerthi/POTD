class Solution_31_leet {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;
        
        // Calculate total sum (S) and initial F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }
        
        long maxVal = f;
        
        // Iteratively calculate F(1) to F(n-1) using the formula
        for (int i = 1; i < n; i++) {
            // F(k) = F(k-1) + sum - n * nums[n-i]
            f = f + sum - (long) n * nums[n - i];
            maxVal = Math.max(maxVal, f);
        }
        
        return (int) maxVal;
    }
}
