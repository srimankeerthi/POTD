import java.util.ArrayList;
import java.util.List;

class Solution_leet_50 {
    public List<Integer> makeBeautiful(int[] arr) {
        List<Integer> result = new ArrayList<>();
        
        for (int num : arr) {
            // If the list is empty, simply add the element
            if (result.isEmpty()) {
                result.add(num);
            } else {
                int top = result.get(result.size() - 1);
                
                // Check if they have different signs
                // Note: 0 is treated as a non-negative (positive) integer
                if ((top >= 0 && num < 0) || (top < 0 && num >= 0)) {
                    // Remove the last element if signs are different
                    result.remove(result.size() - 1);
                } else {
                    // Otherwise, add the current element
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}
