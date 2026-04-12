class Solution_leet_14{
    Integer[][] memo = new Integer[301][27];

    public int minimumDistance(String word) {
        return solve(word, 0, 26);
    }

    private int solve(String word, int idx, int otherFinger) {
        if (idx == word.length()) {
            return 0;
        }
        
        if (memo[idx][otherFinger] != null) {
            return memo[idx][otherFinger];
        }

        int currChar = word.charAt(idx) - 'A';
        
        // Handle the very first character placement (idx == 0)
        // Both fingers are effectively "free" to start here.
        if (idx == 0) {
            // We just place the first finger on word[0] and move to index 1.
            // The "otherFinger" remains 26 (not yet placed).
            return memo[idx][otherFinger] = solve(word, idx + 1, 26);
        }

        // Option 1: Move the finger that just typed word[idx-1]
        int dist1 = getDist(word.charAt(idx - 1) - 'A', currChar);
        int res1 = dist1 + solve(word, idx + 1, otherFinger);

        // Option 2: Move the "other" finger
        int dist2 = 0;
        if (otherFinger != 26) {
            dist2 = getDist(otherFinger, currChar);
        }
        // If we use the other finger, the PREVIOUS finger (at idx-1) 
        // now becomes the new "otherFinger" for the next state.
        int res2 = dist2 + solve(word, idx + 1, word.charAt(idx - 1) - 'A');

        return memo[idx][otherFinger] = Math.min(res1, res2);
    }

    private int getDist(int c1, int c2) {
        int x1 = c1 / 6, y1 = c1 % 6;
        int x2 = c2 / 6, y2 = c2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
