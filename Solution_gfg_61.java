class Solution_gfg_61 {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        // Tracks the rightmost room index covered so far
        int maxCovered = -1; 

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // The current router covers from (i - x) to (i + x)
                int leftReach = i - x;
                int rightReach = i + x;

                // If there's a gap between the last covered room and this router's left reach
                if (leftReach > maxCovered + 1) {
                    return false;
                }

                // Update the maximum rightward coverage reached so far
                maxCovered = Math.max(maxCovered, rightReach);
            }
        }

        // Check if the coverage reaches the last room
        return maxCovered >= n - 1;
    }
}
