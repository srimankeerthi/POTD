class Solution_gfg_10 {
    void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Move left pointer forward if it's already 0
            while (left < right && arr[left] == 0) {
                left++;
            }
            // Move right pointer backward if it's already 1
            while (left < right && arr[right] == 1) {
                right--;
            }

            // If left is at a 1 and right is at a 0, swap them
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}
