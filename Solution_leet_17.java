import java.util.*;

class Solution_leet_17 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: Store all indices for each unique value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int qIdx : queries) {
            int val = nums[qIdx];
            List<Integer> indices = map.get(val);
            
            // If the element is unique in the array
            if (indices.size() <= 1) {
                result.add(-1);
                continue;
            }
            
            // Step 2: Binary Search to find the position of the current index
            int pos = Collections.binarySearch(indices, qIdx);
            
            int minDist = Integer.MAX_VALUE;
            int m = indices.size();
            
            // Step 3: Check neighbors in the sorted list
            // Check right neighbor
            int rightNeighbor = indices.get((pos + 1) % m);
            minDist = Math.min(minDist, getCircularDist(qIdx, rightNeighbor, n));
            
            // Check left neighbor
            int leftNeighbor = indices.get((pos - 1 + m) % m);
            minDist = Math.min(minDist, getCircularDist(qIdx, leftNeighbor, n));
            
            result.add(minDist);
        }
        
        return result;
    }
    
    // Helper to calculate the shortest distance in a circular array
    private int getCircularDist(int i, int j, int n) {
        int absDiff = Math.abs(i - j);
        return Math.min(absDiff, n - absDiff);
    }
}
