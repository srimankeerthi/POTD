class Solution_gfg_18{
    boolean canFormPalindrome(String s) {
        // Since we only have lowercase English letters
        int[] count = new int[26];
        
        // Count frequencies of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Count how many characters have an odd frequency
        int oddCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
            }
        }
        
        // If more than 1 character has an odd frequency, 
        // it cannot form a palindrome.
        return oddCount <= 1;
    }
}
