class Solution_leet_73 {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;
        
        // Step 1: Add all elements less than pivot
        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }
        
        // Step 2: Add all elements equal to pivot
        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }
        
        // Step 3: Add all elements greater than pivot
        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }
        
        return result;
    }
}
