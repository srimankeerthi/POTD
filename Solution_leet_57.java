class Solution_leet_57 {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Compare current element with the next element (using % for wrap-around)
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            
            // If we find more than one violation, it can't be a rotated sorted array
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}
