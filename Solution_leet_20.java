class Solution_leet_20 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2
        int maxDist = 0;
        
        // Iterate through both arrays
        while (i < nums1.length && j < nums2.length) {
            // Check if the condition is valid: i <= j and nums1[i] <= nums2[j]
            // Note: i <= j is naturally handled by moving j forward
            if (nums1[i] <= nums2[j]) {
                // Update max distance
                maxDist = Math.max(maxDist, j - i);
                // Try to find a larger j for the current i
                j++;
            } else {
                // nums1[i] is too large, move i to the right to find a smaller value
                i++;
            }
        }
        
        return maxDist;
    }
}
