import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution_gfg_54 {
    public int minSteps(int[] arr, int start, int end) {
        // If start and end are already the same, 0 steps are needed.
        if (start == end) {
            return 0;
        }
        
        // Define the modulo limit as per the problem constraints
        int MOD = 1000;
        
        // dist array to store the minimum steps taken to reach each number from 0 to 999
        int[] dist = new int[MOD];
        Arrays.fill(dist, -1); 
        
        // Queue for BFS storing the numbers
        Queue<Integer> q = new LinkedList<>();
        
        // Initialize BFS with the start node
        q.add(start);
        dist[start] = 0;
        
        // Traverse the graph
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            
            int steps = dist[node];
            
            // Multiply the current node with every element in the array
            for (int factor : arr) {
                int nextNode = (node * factor) % MOD;
                
                // If this state hasn't been visited yet
                if (dist[nextNode] == -1) {
                    dist[nextNode] = steps + 1;
                    
                    // If we reached the destination, return the answer immediately
                    if (nextNode == end) {
                        return dist[nextNode];
                    }
                    
                    q.add(nextNode);
                }
            }
        }
        
        // If the queue is empty and end was never reached
        return -1;
    }
}
