class Solution_gfg_24 {
    public boolean canSplit(int arr[]) {
        long totalSum = 0;
        
        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, it's impossible to split 
        // into two equal integer sums.
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long leftSum = 0;
        // Step 2: Iterate and find the split point
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            
            // Step 3: Check if left part equals the remaining right part
            if (leftSum == totalSum - leftSum) {
                return true;
            }
        }
        
        return false;
    }
}
