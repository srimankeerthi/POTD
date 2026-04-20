class Solution_leet_21 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        
        // Strategy 1: Compare the first house with houses from the right end
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i);
                break;
            }
        }
        
        // Strategy 2: Compare the last house with houses from the left end
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, (n - 1) - i);
                break;
            }
        }
        
        return maxDist;
    }
}
