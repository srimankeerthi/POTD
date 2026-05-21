import java.util.HashSet;

class Solution_leet_55{
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        
        // Step 1: Insert all possible prefixes of numbers in arr1 into the HashSet
        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10; // Strips the last digit to get the next prefix
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check all possible prefixes of numbers in arr2 against the HashSet
        for (int val : arr2) {
            while (val > 0) {
                if (prefixes.contains(val)) {
                    // String.valueOf(val).length() gives the length of the matching prefix
                    maxLength = Math.max(maxLength, String.valueOf(val).length());
                    break; // Optimization: Shorter prefixes of the same number won't beat maxLength
                }
                val /= 10;
            }
        }
        
        return maxLength;
    }
}
