class Solution_leet_38 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            // Define boundaries for the current layer
            int top = layer, left = layer;
            int bottom = m - 1 - layer, right = n - 1 - layer;

            // 1. Extract elements of the current layer (Counter-Clockwise)
            List<Integer> elements = new ArrayList<>();
            for (int j = left; j < right; j++) elements.add(grid[top][j]);      // Top row
            for (int i = top; i < bottom; i++) elements.add(grid[i][right]);   // Right col
            for (int j = right; j > left; j--) elements.add(grid[bottom][j]);  // Bottom row
            for (int i = bottom; i > top; i--) elements.add(grid[i][left]);    // Left col

            // 2. Calculate effective rotation
            int totalElements = elements.size();
            int netK = k % totalElements;

            // 3. Put elements back into the grid with rotation offset
            int idx = netK; // Start from the rotated position
            for (int j = left; j < right; j++) {
                grid[top][j] = elements.get(idx % totalElements);
                idx++;
            }
            for (int i = top; i < bottom; i++) {
                grid[i][right] = elements.get(idx % totalElements);
                idx++;
            }
            for (int j = right; j > left; j--) {
                grid[bottom][j] = elements.get(idx % totalElements);
                idx++;
            }
            for (int i = bottom; i > top; i--) {
                grid[i][left] = elements.get(idx % totalElements);
                idx++;
            }
        }
        return grid;
    }
}
