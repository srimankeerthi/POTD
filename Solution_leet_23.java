import java.util.ArrayList;
import java.util.List;

class Solution_leet_23 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        
        for (String query : queries) {
            for (String word : dictionary) {
                if (canMatch(query, word)) {
                    result.add(query);
                    break; // Found a match within 2 edits, move to next query
                }
            }
        }
        
        return result;
    }
    
    private boolean canMatch(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            // Optimization: if we exceed 2 edits, this word is a no-go
            if (diff > 2) {
                return false;
            }
        }
        return true;
    }
}
