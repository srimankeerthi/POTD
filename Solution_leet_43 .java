class Solution_leet_43 {
    public int findMotherVertex(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        int lastFinishedVertex = 0;

     
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                lastFinishedVertex = i;
            }
        }

        Arrays.fill(visited, false);
        dfs(lastFinishedVertex, adj, visited);

        for (boolean val : visited) {
            if (!val) return -1;
        }

        return lastFinishedVertex;
    }

    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }
}
