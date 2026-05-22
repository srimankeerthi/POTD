class Solution_gfg_56{
    int cntOnes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Step 1: Traverse the first and last columns
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0, n, m);
            }
            if (grid[i][m - 1] == 1) {
                dfs(grid, i, m - 1, n, m);
            }
        }
        
        // Step 2: Traverse the first and last rows
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j, n, m);
            }
            if (grid[n - 1][j] == 1) {
                dfs(grid, n - 1, j, n, m);
            }
        }
        
        // Step 3: Count remaining 1s (which are trapped)
        int trappedOnes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    trappedOnes++;
                } else if (grid[i][j] == -1) {
                    // Restore the grid state if needed (optional)
                    grid[i][j] = 1;
                }
            }
        }
        
        return trappedOnes;
    }
    
    private void dfs(int[][] grid, int r, int c, int n, int m) {
        // Base cases: boundary checks or if cell is not an escapable '1'
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != 1) {
            return;
        }
        
        // Mark the cell as visited/escapable by changing 1 to -1
        grid[r][c] = -1;
        
        // Explore 4-directional neighbors
        dfs(grid, r + 1, c, n, m); // Down
        dfs(grid, r - 1, c, n, m); // Up
        dfs(grid, r, c + 1, n, m); // Right
        dfs(grid, r, c - 1, n, m); // Left
    }
}
