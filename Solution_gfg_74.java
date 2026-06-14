import java.util.ArrayList;
import java.util.List;

class Solution_gfg_74 {
    public List<Integer> exitPoint(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Direction vectors: 0 -> Right, 1 -> Down, 2 -> Left, 3 -> Up
        int[] dRow = {0, 1, 0, -1};
        int[] dCol = {1, 0, -1, 0};
        
        int r = 0, c = 0; // Starting position
        int dir = 0;      // Starting direction (Right)
        
        // Track the last valid cell position before stepping out
        int lastR = 0, lastC = 0;
        
        while (r >= 0 && r < n && c >= 0 && c < m) {
            // Store the current coordinates as the last known valid position
            lastR = r;
            lastC = c;
            
            // Rule: If it's 1, change direction clockwise and turn it to 0
            if (mat[r][c] == 1) {
                dir = (dir + 1) % 4;
                mat[r][c] = 0;
            }
            
            // Move to the next cell
            r += dRow[dir];
            c += dCol[dir];
        }
        
        // Prepare the answer list containing the exit row and column
        List<Integer> ans = new ArrayList<>();
        ans.add(lastR);
        ans.add(lastC);
        
        return ans;
    }
}
