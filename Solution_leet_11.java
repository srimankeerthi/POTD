class Solution_leet_11{
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;
        int n = nums.length;
        int sqrtN = 60; // Optimal threshold for this problem size

        // diff[k][i] will store the "multiplication impact" for step k
        long[][] diff = new long[sqrtN + 1][n + sqrtN + 1];
        for (int k = 1; k <= sqrtN; k++) {
            for (int i = 0; i < diff[k].length; i++) diff[k][i] = 1L;
        }

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k > sqrtN) {
                // Large k: Simulation is fast because steps are few
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) (((long) nums[i] * v) % MOD);
                }
            } else {
                // Small k: Use difference array logic
                // Multiply at start of range
                diff[k][l] = (diff[k][l] * v) % MOD;
                // Divide at the first index past the range (r + k)
                // Using Modular Inverse since 10^9 + 7 is prime
                long invV = power(v, MOD - 2, MOD);
                int nextIdx = r + k - (r - l) % k; 
                // Simplified: the next element in the sequence after r is l + k * ( (r-l)/k + 1 )
                int endIdx = l + k * ((r - l) / k + 1);
                if (endIdx < n + k) {
                    diff[k][endIdx] = (diff[k][endIdx] * invV) % MOD;
                }
            }
        }

        // Apply prefix products for each small k
        for (int k = 1; k <= sqrtN; k++) {
            for (int i = k; i < n; i++) {
                diff[k][i] = (diff[k][i] * diff[k][i - k]) % MOD;
            }
        }

        // Combine everything into the final XOR
        int result = 0;
        for (int i = 0; i < n; i++) {
            long totalMult = 1;
            for (int k = 1; k <= sqrtN; k++) {
                totalMult = (totalMult * diff[k][i]) % MOD;
            }
            result ^= (int) (((long) nums[i] * totalMult) % MOD);
        }

        return result;
    }

    // Fast Modular Exponentiation for Modular Inverse
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}