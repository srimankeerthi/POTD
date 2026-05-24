class Solution_gfg_59 {
    public int coin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        // Simulating the greedy game until only one coin is left
        while (left < right) {
            if (arr[left] > arr[right]) {
                left++; // Player picks the coin at the beginning
            } else {
                right--; // Player picks the coin at the end
            }
        }
        
        // The last remaining coin
        return arr[left];
    }
}
