import java.util.*;

class Solution_gfg_75 {
    public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] reachP = new boolean[n][m];
        boolean[][] reachQ = new boolean[n][m];

        Queue<int[]> queueP = new LinkedList<>();
        Queue<int[]> queueQ = new LinkedList<>();

        // 1. Initialize Station P boundaries (Top row and Left column)
        for (int j = 0; j < m; j++) {
            reachP[0][j] = true;
            queueP.offer(new int[]{0, j});
        }
        for (int i = 1; i < n; i++) { // avoid duplicating (0,0)
            reachP[i][0] = true;
            queueP.offer(new int[]{i, 0});
        }

        // 2. Initialize Station Q boundaries (Bottom row and Right column)
        for (int j = 0; j < m; j++) {
            reachQ[n - 1][j] = true;
            queueQ.offer(new int[]{n - 1, j});
        }
        for (int i = 0; i < n - 1; i++) { // avoid duplicating (n-1, m-1)
            reachQ[i][m - 1] = true;
            queueQ.offer(new int[]{i, m - 1});
        }

        // 3. Run BFS for both stations
        bfs(mat, queueP, reachP, n, m);
        bfs(mat, queueQ, reachQ, n, m);

        // 4. Count cells that can reach both stations
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (reachP[i][j] && reachQ[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int[][] mat, Queue<int[]> queue, boolean[][] reach, int n, int m) {
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                // Check bounds and if it hasn't been visited yet
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !reach[nr][nc]) {
                    // Reverse flow condition: neighboring tower must be >= current tower
                    if (mat[nr][nc] >= mat[r][c]) {
                        reach[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
