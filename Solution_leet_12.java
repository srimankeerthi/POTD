import java.util.*;

class Solution_leet_12 {
    public int minimumDistance(int[] nums) {
        // Map each number to a list of the indices where it appears
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }

        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        // Iterate through each group of indices
        for (List<Integer> indices : indexMap.values()) {
            // A "good" tuple requires at least 3 occurrences of the same number
            if (indices.size() >= 3) {
                found = true;
                // Check sliding windows of 3 consecutive indices
                // The minimum distance for i < j < k is always 2 * (k - i)
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int leftIdx = indices.get(i);
                    int rightIdx = indices.get(i + 2);
                    
                    int currentDist = 2 * (rightIdx - leftIdx);
                    minDistance = Math.min(minDistance, currentDist);
                }
            }
        }

        return found ? minDistance : -1;
    }
}
