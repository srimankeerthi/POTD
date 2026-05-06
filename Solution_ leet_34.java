class Solution_ leet_34{
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // 1. Apply Gravity: Move stones to the right in their current rows
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // The rightmost available position
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    // Move stone to the 'empty' slot
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                } else if (boxGrid[i][j] == '*') {
                    // Obstacle resets the 'empty' slot to the left of it
                    empty = j - 1;
                }
            }
        }

        // 2. Rotate the matrix 90 degrees clockwise
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // (i, j) maps to (j, m - 1 - i)
                rotatedBox[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotatedBox;
    }
}
