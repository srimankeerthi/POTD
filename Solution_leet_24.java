import java.util.*;

class Solution_leet_24 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        // Map: Value -> List of indices where this value appears
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Process each unique number's indices
        for (List<Integer> indices : map.values()) {
            int m = indices.size();
            if (m <= 1) continue;

            // Calculate total sum of indices for this value
            long totalSum = 0;
            for (int index : indices) {
                totalSum += index;
            }

            long prefixSum = 0;
            for (int i = 0; i < m; i++) {
                long currentIndex = indices.get(i);
                
                // Sum of distances to the left: 
                // (count of elements on left * current index) - sum of those indices
                long leftSum = (long) i * currentIndex - prefixSum;
                
                // Sum of distances to the right:
                // sum of indices on right - (count of elements on right * current index)
                long suffixSum = (totalSum - prefixSum - currentIndex);
                long rightSum = suffixSum - (long) (m - i - 1) * currentIndex;

                res[(int) currentIndex] = leftSum + rightSum;
                
                // Update prefixSum for the next index in the list
                prefixSum += currentIndex;
            }
        }

        return res;
    }
}
