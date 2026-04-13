class Solution_leet_15{
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            // Check if the current element is our target
            if (nums[i] == target) {
                // Calculate absolute distance
                int currentDist = Math.abs(i - start);
                
                // Update minDist if we found a smaller one
                if (currentDist < minDist) {
                    minDist = currentDist;
                }
                
                // Optional optimization: If distance is 0, we can't do better
                if (minDist == 0) return 0;
            }
        }
        
        return minDist;
    }
}
