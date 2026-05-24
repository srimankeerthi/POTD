class Solution_leet_58{
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        int maxVisited = 0;
        
        // Find the maximum jumps starting from every possible index
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i, memo));
        }
        
        return maxVisited;
    }
    
    private int dfs(int[] arr, int d, int i, int[] memo) {
        // Return cached result if already calculated
        if (memo[i] != 0) {
            return memo[i];
        }
        
        int maxJumpsFromI = 1; // Current index itself counts as 1
        int n = arr.length;
        
        // 1. Check jumps to the right (i + x)
        for (int x = 1; x <= d && i + x < n; x++) {
            // Cannot jump over or to a bar that is >= arr[i]
            if (arr[i + x] >= arr[i]) {
                break;
            }
            maxJumpsFromI = Math.max(maxJumpsFromI, 1 + dfs(arr, d, i + x, memo));
        }
        
        // 2. Check jumps to the left (i - x)
        for (int x = 1; x <= d && i - x >= 0; x++) {
            // Cannot jump over or to a bar that is >= arr[i]
            if (arr[i - x] >= arr[i]) {
                break;
            }
            maxJumpsFromI = Math.max(maxJumpsFromI, 1 + dfs(arr, d, i - x, memo));
        }
        
        // Save to cache and return
        memo[i] = maxJumpsFromI;
        return memo[i];
    }
}
