class Solution_gfg_14{
    public boolean isToeplitz(int[][] mat) {
        // Get dimensions of the matrix
        int n = mat.length;
        int m = mat[0].length;

        // Iterate through each element starting from (1, 1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // Check if current element is same as its top-left neighbor
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        // If no mismatches were found, it's a Toeplitz matrix
        return true;
    }
}
