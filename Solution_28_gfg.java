class Solution_28_gfg {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] count = new int[26]; // To store frequency of characters
        int maxCount = 0; // Frequency of the most frequent character in the current window
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            // Add current character to the window
            char current = s.charAt(right);
            count[current - 'A']++;
            
            // Update maxCount with the frequency of the most frequent character seen so far
            maxCount = Math.max(maxCount, count[current - 'A']);

            // If (window size - max frequency) > k, it's an invalid window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
