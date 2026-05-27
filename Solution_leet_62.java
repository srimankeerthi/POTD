class Solution_leet_62{
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        
        // Initialize arrays with -1 to indicate "not found"
        java.util.Arrays.fill(lastLower, -1);
        java.util.Arrays.fill(firstUpper, -1);
        
        // Traverse the string to record positions
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lastLower[ch - 'a'] = i; // Continually update to get the LAST occurrence
            } else {
                int idx = ch - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i; // Only update once to get the FIRST occurrence
                }
            }
        }
        
        int specialCount = 0;
        
        // Check the condition for each alphabet character
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}
