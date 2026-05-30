class Solution_gfg_63 {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        // Store the original value of the first element
        int prev = arr[0];
        
        // Update the first element
        arr[0] = arr[0] ^ arr[1];
        
        // Update middle elements
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i]; // Backup the current original value
            arr[i] = prev ^ arr[i + 1]; // XOR of previous original and next original
            prev = curr; // Move the backup to 'prev' for the next iteration
        }
        
        // Update the last element
        arr[n - 1] = prev ^ arr[n - 1];
    }
}
