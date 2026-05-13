class Solution_gfg_45 {
    public int minMoves(int[] nums, int limit) {
        // delta[i] stores the difference in moves for target sum i
        int[] delta = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            
            // Default: 2 moves for all possible sums [2, 2*limit]
            delta[2] += 2;
            delta[2 * limit + 1] -= 2;
            
            // Range for 1 move: [min(a, b) + 1, max(a, b) + limit]
            // We subtract 1 move from the "2 moves" default in this range
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;
            delta[low] -= 1;
            delta[high + 1] += 1;
            
            // Range for 0 moves: exactly a + b
            // We subtract 1 move from the "1 move" result for this specific sum
            int sum = a + b;
            delta[sum] -= 1;
            delta[sum + 1] += 1;
        }

        int minMoves = n; // Max possible moves is n
        int currentMoves = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            currentMoves += delta[i];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
