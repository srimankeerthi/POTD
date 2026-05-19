class Solution_leet_53{
    public int getCommon(int[] nums1, int[] nums2) {
        // Quick optimization check: if there's no overlap between ranges
        if (nums1[nums1.length - 1] < nums2[0] || nums2[nums2.length - 1] < nums1[0]) {
            return -1;
        }

        int i = 0; // Pointer for nums1
        int j = 0; // Pointer for nums2

        // Traverse both arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]; // Found the minimum common value
            } else if (nums1[i] < nums2[j]) {
                i++; // Move nums1 pointer forward
            } else {
                j++; // Move nums2 pointer forward
            }
        }

        return -1; // No common element found
    }
}
