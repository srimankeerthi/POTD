import java.util.*;

class Solution_leet_8{
    public int robotSim(int[] commands, int[][] obstacles) {
        
        // Store obstacles in HashSet
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }

        // Directions: N, E, S, W
        int[][] dir = {
            {0, 1},   // North
            {1, 0},   // East
            {0, -1},  // South
            {-1, 0}   // West
        };

        int x = 0, y = 0;
        int d = 0; // initially facing North
        int maxDist = 0;

        for (int cmd : commands) {

            // Turn left
            if (cmd == -2) {
                d = (d + 3) % 4;
            }
            // Turn right
            else if (cmd == -1) {
                d = (d + 1) % 4;
            }
            // Move forward
            else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    // Stop if obstacle
                    if (set.contains(nx + "," + ny)) break;

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}