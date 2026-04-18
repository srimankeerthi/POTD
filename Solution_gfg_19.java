class Solution_gfg_19{
    int maxOnes(int arr[]) {
        int n = arr.length;
        int originalOnes = 0;
        int maxGain = 0;
        int currentGain = 0;

        for (int i = 0; i < n; i++) {
            // Count original 1s
            if (arr[i] == 1) {
                originalOnes++;
            }

            // Calculate gain: 0 yields +1, 1 yields -1
            int value = (arr[i] == 0) ? 1 : -1;
            
            currentGain += value;
            
            // Standard Kadane's: if currentGain drops below 0, reset it
            if (currentGain < 0) {
                currentGain = 0;
            }
            
            // Update the maximum gain found so far
            if (currentGain > maxGain) {
                maxGain = currentGain;
            }
        }

        return originalOnes + maxGain;
    }
}
