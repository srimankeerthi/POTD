class Solution_gfg_38 {
    public int countSpanTree(int n, int[][] edges) {
        if (n <= 1) return 1;

        // 1. Create the Laplacian Matrix
        double[][] laplacian = new double[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            laplacian[u][u]++;
            laplacian[v][v]++;
            laplacian[u][v]--;
            laplacian[v][u]--;
        }

        // 2. Get the reduced matrix (remove last row and column)
        int size = n - 1;
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = laplacian[i][j];
            }
        }

        // 3. Calculate Determinant using Gaussian Elimination
        return (int) Math.round(determinant(matrix, size));
    }

    private double determinant(double[][] matrix, int n) {
        double det = 1.0;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i])) pivot = j;
            }
            
            // Swap rows
            double[] temp = matrix[i];
            matrix[i] = matrix[pivot];
            matrix[pivot] = temp;
            
            if (pivot != i) det *= -1;
            if (Math.abs(matrix[i][i]) < 1e-9) return 0;

            det *= matrix[i][i];
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i + 1; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
        return det;
    }
}
