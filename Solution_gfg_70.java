
class Solution_gfg_70 {
    int maxSubstring(String s) {
        int maxFar = Integer.MIN_VALUE;
        int currMax = 0;
        boolean hasZero = false;

        for (int i = 0; i < s.length(); i++) {
            // Map '0' to 1 and '1' to -1
            int val = (s.charAt(i) == '0') ? 1 : -1;
            
            if (val == 1) {
                hasZero = true;
            }

            currMax += val;

            if (currMax > maxFar) {
                maxFar = currMax;
            }

            // If the running sum drops below 0, reset it
            if (currMax < 0) {
                currMax = 0;
            }
        }

        // Edge case: If the string contains only '1's, return -1
        if (!hasZero) {
            return -1;
        }

        return maxFar;
    }
}
