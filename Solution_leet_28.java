class Solution_leet_27 {
    // map[street_type] = {dy, dx} pairs it connects to
    // Directions: 0: Up (-1,0), 1: Down (1,0), 2: Left (0,-1), 3: Right (0,1)
    private int[][][] drive = {
        {}, // placeholder for 0
        {{0, -1}, {0, 1}},  // 1: left, right
        {{-1, 0}, {1, 0}},  // 2: up, down
        {{0, -1}, {1, 0}},  // 3: left, down
        {{0, 1}, {1, 0}},   // 4: right, down
        {{0, -1}, {-1, 0}}, // 5: left, up
        {{0, 1}, {-1, 0}}   // 6: right, up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            if (r == m - 1 && c == n - 1) return true;

            for (int[] dir : drive[grid[r][c]]) {
                int nr = r + dir[0], nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // Check if the neighbor can connect back to current cell (r, c)
                    for (int[] backDir : drive[grid[nr][nc]]) {
                        if (nr + backDir[0] == r && nc + backDir[1] == c) {
                            visited[nr][nc] = true;
                            queue.add(new int[]{nr, nc});
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}
