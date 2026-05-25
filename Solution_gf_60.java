import java.util.HashSet;

class Solution_gf_60 {
    public boolean checkElements(int start, int end, int[] arr) {
        // Step 1: Create a HashSet and add all array elements to it
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        // Step 2: Check if every number from start to end exists in the set
        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) {
                return false; // Found a missing element
            }
        }
        
        // All elements in the range are present
        return true;
    }
}
