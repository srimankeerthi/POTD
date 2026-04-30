class Solution_gfg_30 {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        // We only need to check internal nodes. 
        // Nodes from (n/2) to n-1 are leaf nodes and have no children.
        for (int i = 0; i <= (n - 2) / 2; i++) {
            
            // Check if left child exists and violates max-heap property
            if (2 * i + 1 < n && arr[i] < arr[2 * i + 1]) {
                return false;
            }
            
            // Check if right child exists and violates max-heap property
            if (2 * i + 2 < n && arr[i] < arr[2 * i + 2]) {
                return false;
            }
        }
        
        return true;
    }
}
