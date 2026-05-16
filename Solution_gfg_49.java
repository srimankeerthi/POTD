class Solution_gfg_49{
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right unsorted part
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // The right part is sorted, so mid could be the minimum or to its left
                right = mid;
            } else {
                // When nums[mid] == nums[right], we can't decide the side.
                // Safely reduce the search space by shifting the right boundary.
                right--;
            }
        }
        
        return nums[left];
    }
}
