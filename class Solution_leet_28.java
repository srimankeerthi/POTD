import java.util.Arrays;

class Solution_leet_28{
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        
        // 1. Flatten the grid into a 1D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = grid[i][j];
            }
        }
        
        // 2. Sort to find the median
        Arrays.sort(arr);
        
        int median = arr[arr.length / 2];
        int operations = 0;
        
        for (int val : arr) {
            int diff = Math.abs(val - median);
            
            // 3. Check if it's possible to reach the median
            if (diff % x != 0) {
                return -1;
            }
            
            operations += diff / x;
        }
        
        return operations;
    }
}
