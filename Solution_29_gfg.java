class Solution_29_gfg {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;

        // Step 1: Count total number of 1s
        for (int num : arr) {
            if (num == 1) totalOnes++;
        }

        // Edge case: No 1s present
        if (totalOnes == 0) return -1;
        
        // Step 2: Initialize the first window of size 'totalOnes'
        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (arr[i] == 1) currentOnes++;
        }

        int maxOnesInWindow = currentOnes;

        // Step 3: Slide the window across the array
        for (int i = totalOnes; i < n; i++) {
            // Add the new element entering the window
            if (arr[i] == 1) currentOnes++;
            // Remove the element leaving the window
            if (arr[i - totalOnes] == 1) currentOnes--;

            // Update the maximum 1s found in any window
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        // Step 4: Minimum swaps = total 1s - max 1s found in a window
        return totalOnes - maxOnesInWindow;
    }
}
