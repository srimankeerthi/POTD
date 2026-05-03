import java.util.*;

class Solution_gfg_32 {
    public ArrayList<Integer> sortBySetBitCount(int arr[]) {
        int n = arr.length;
        
        // 1. Create an Integer array to store the elements.
        // We use Integer (Object) instead of int (primitive) because 
        // Arrays.sort(Object[]) is a STABLE sort (TimSort).
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }

        // 2. Sort the array based on set bit counts in descending order.
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            // Compare countB to countA for descending order.
            // If bit counts are equal, TimSort preserves the original input order.
            return Integer.compare(countB, countA);
        });

        // 3. Convert the sorted Integer array into an ArrayList to match the return type.
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : temp) {
            result.add(val);
        }

        return result;
    }
}
