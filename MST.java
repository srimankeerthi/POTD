class MST{
    public int minCost(int[][] houses) {
        int n = houses.length;
        
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        
        // Initialize distances
        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        
        minDist[0] = 0; // start from first house
        int totalCost = 0;
        
        for (int i = 0; i < n; i++) {
            int u = -1;
            
            // pick minimum distance node not visited
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            
            visited[u] = true;
            totalCost += minDist[u];
            
            // update distances
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(houses[u][0] - houses[v][0]) +
                               Math.abs(houses[u][1] - houses[v][1]);
                    
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                    }
                }
            }
        }
        
        return totalCost;
    }
}
