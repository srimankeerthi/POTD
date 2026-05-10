import java.util.*;

class Solution_gfg_39{
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        long totalProfit = 0;
        
        // Use an Integer array to store indices for custom sorting
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
            // Initially assume all tasks go to Machine B
            totalProfit += b[i];
        }

        // Sort indices based on the profit gain (a[i] - b[i]) in descending order
        Arrays.sort(indices, (i, j) -> (a[j] - b[j]) - (a[i] - b[i]));

        // Constraints: Machine A must take at least (n - y) tasks and at most x tasks
        int minA = Math.max(0, n - y);
        int maxA = x;

        for (int i = 0; i < maxA; i++) {
            int idx = indices[i];
            int gain = a[idx] - b[idx];
            
            // Mandatory tasks for A to satisfy Machine B's capacity
            if (i < minA) {
                totalProfit += gain;
            } 
            // Optional tasks for A: only take if it increases profit
            else if (gain > 0) {
                totalProfit += gain;
            } else {
                break; // Gains are sorted; no more positive gains exist
            }
        }

        // Cast to int to satisfy the GFG driver code requirement
        return (int) totalProfit;
    }
}
