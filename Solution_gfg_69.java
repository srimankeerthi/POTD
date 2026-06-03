import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

class Solution_gfg_69 {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Map to store the list of indices for each unique element
        HashMap<Integer, ArrayList<Integer>> elementIndices = new HashMap<>();
        
        // Populate the map with indices
        for (int i = 0; i < arr.length; i++) {
            elementIndices.putIfAbsent(arr[i], new ArrayList<>());
            elementIndices.get(arr[i]).add(i);
        }
        
        // Process each query
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int x = query[2];
            
            // If the element doesn't exist in the array at all
            if (!elementIndices.containsKey(x)) {
                result.add(0);
                continue;
            }
            
            ArrayList<Integer> indices = elementIndices.get(x);
            
            // Find the number of elements <= r and subtract elements < l
            int countRight = binarySearchUpperBound(indices, r);
            int countLeft = binarySearchLowerBound(indices, l);
            
            result.add(countRight - countLeft);
        }
        
        return result;
    }
    
    // Finds the number of elements in the list that are less than or equal to 'target'
    private int binarySearchUpperBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= target) {
                ans = mid + 1; // All elements up to mid are valid
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    // Finds the number of elements in the list that are strictly less than 'target'
    private int binarySearchLowerBound(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                ans = mid + 1; // All elements up to mid are valid
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
