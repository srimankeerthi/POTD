class Solution_leet_67 {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        
        // Edge case: single element
        if (n == 1) {
            return arr[0];
        }

        long maxNeg = Long.MIN_VALUE;
        int countNeg = 0;
        int countZero = 0;
        long prod = 1;
        long MOD = 1000000007;
        
        // Flag to check if we included any non-zero element in our product
        boolean insideProd = false; 

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                continue;
            }

            if (arr[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, arr[i]);
            }

            // Multiply non-zero elements
            prod = (prod * arr[i]) % MOD;
            insideProd = true;
        }

        // Edge Case: If all elements are zeros
        if (countZero == n) {
            return 0;
        }

        // Edge Case: If there is an odd number of negatives
        if (countNeg % 2 != 0) {
            // If there is only one negative element and the rest are zeros
            if (countNeg == 1 && countZero + countNeg == n) {
                return 0;
            }
            
            // Remove the least negative element from the product
            // Modulo arithmetic division under a prime field (using modular inverse)
            // or simply rebuilding the product by skipping maxNeg is safer.
            // Let's rebuild safely to avoid tricky modular inverse with negative numbers.
            prod = 1;
            boolean skipped = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;
                if (arr[i] == maxNeg && !skipped) {
                    skipped = true; // skip the maximum negative element once
                    continue;
                }
                prod = (prod * arr[i]) % MOD;
            }
        }

        // Ensure the result is positive if it wrapped around negatively during operations
        return (int) ((prod + MOD) % MOD);
    }
}
