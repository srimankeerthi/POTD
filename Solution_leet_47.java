class Solution_leet_47 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum must be in the right part
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left part
                right = mid;
            }
        }

        // Left and right converge to the minimum element
        return nums[left];
    }
}
