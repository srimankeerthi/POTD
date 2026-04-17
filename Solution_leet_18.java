import java.util.HashMap;
import java.util.Map;

class Solution_leet_18{
    public int minMirrorPairDistance(int[] nums) {
        // Map stores: Key = the mirror target we are looking for
        // Value = the most recent index of the number that wants that target
        Map<Integer, Integer> targets = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int j = 0; j < nums.length; j++) {
            int currentNum = nums[j];

            // 1. Check if the current number is a mirror of a PREVIOUS number
            if (targets.containsKey(currentNum)) {
                minDistance = Math.min(minDistance, j - targets.get(currentNum));
                found = true;
            }

            // 2. Calculate the mirror target for THIS number to be found by FUTURE numbers
            // e.g., if current is 120, its mirror target is 21.
            int targetForFuture = reverse(currentNum);
            
            // Always update to the latest index to keep distance minimal
            targets.put(targetForFuture, j);
        }

        return found ? minDistance : -1;
    }

    private int reverse(int n) {
        if (n == 0) return 0;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}
