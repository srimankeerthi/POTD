class Solution_gfg_31 {
    static int findPosition(int n) {
        // Step 1: Check if n is a power of 2 and greater than 0
        // A power of 2 in binary looks like 1 followed by zeros (e.g., 8 is 1000)
        if (n <= 0 || (n & (n - 1)) != 0) {
            return -1;
        }

        int count = 0;
        // Step 2: Shift bits to the right until n becomes 0
        while (n > 0) {
            n = n >> 1;
            count++;
        }

        return count;
    }
}
