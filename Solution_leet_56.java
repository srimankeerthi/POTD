class Solution_leet_56 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // 1. If we found the target, return its index
            if (nums[mid] == target) {
                return mid;
            }
            
            // 2. Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if the target lies within the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            } 
            // 3. Otherwise, the right half must be sorted
            else {
                // Check if the target lies within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }
        
        // Target was not found in the array
        return -1;
    }
}
