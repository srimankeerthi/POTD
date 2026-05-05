class Solution_leet_34 {
    public long sumXOR(int[] arr) {
        long totalSum = 0;
        int n = arr.length;

        // Iterate through each bit position (0 to 31)
        for (int i = 0; i < 32; i++) {
            long countSetBits = 0;
            
            // Count how many numbers have the i-th bit set
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    countSetBits++;
                }
            }
            
            // Count of numbers with i-th bit unset
            long countUnsetBits = n - countSetBits;
            
            // Number of pairs with different i-th bits = countSetBits * countUnsetBits
            // Contribution to sum = (pairs) * 2^i
            totalSum += (countSetBits * countUnsetBits) * (1L << i);
        }

        return totalSum;
    }
}
