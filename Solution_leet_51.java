import java.util.*;

class Solution_leet_51 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        // Step 1: Map each value to all its occurrence indices
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        // Step 2: Initialize BFS queue and visited array
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        // Step 3: Standard Layer-by-Layer BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // If we reached the last index, return the step count
                if (curr == n - 1) {
                    return steps;
                }

                // Option 1: Jump to curr + 1
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Option 2: Jump to curr - 1
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                // Option 3: Jump to any index j where arr[curr] == arr[j]
                if (graph.containsKey(arr[curr])) {
                    for (int nextIdx : graph.get(arr[curr])) {
                        if (nextIdx != curr && !visited[nextIdx]) {
                            visited[nextIdx] = true;
                            queue.offer(nextIdx);
                        }
                    }
                    // CRITICAL OPTIMIZATION: Clear the list to prevent redundant O(N) scans
                    graph.remove(arr[curr]);
                }
            }
            steps++;
        }

        return -1;
    }
}
