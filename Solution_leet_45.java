class Solution_leet_45 {
    public boolean isGood(int[] nums) {
        int n = 0;
        // 1. Find the maximum element n
        for (int num : nums) {
            if (num > n) n = num;
        }

        // 2. Check if the length matches base[n] requirement (n + 1)
        if (nums.length != n + 1) {
            return false;
        }

        // 3. Count occurrences of each number
        int[] counts = new int[n + 1];
        for (int num : nums) {
            // If any number exceeds n, it's invalid (though n is our max)
            counts[num]++;
        }

        // 4. Verify the permutation rules
        for (int i = 1; i < n; i++) {
            if (counts[i] != 1) return false;
        }
        
        // n must appear exactly twice
        return counts[n] == 2;
    }
}
