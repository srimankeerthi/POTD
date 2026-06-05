class Solution_gfg_71{
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        
        // Step 1: Check if n is a power of 2 and adjust k
        if ((n & (n - 1)) == 0) {
            k = k / 2;
        } else {
            k = k * 2;
        }
        
        // Step 2: Handle edge cases where it's impossible or result is empty
        if (k >= n) {
            return "-1";
        }
        
        // Step 3: Greedy approach using a StringBuilder as a stack
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            // While stack is not empty, current char is smaller, and we can still remove elements
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(ch);
        }
        
        // If we still need to remove characters, remove them from the end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        // Double-check if the final string is empty
        if (sb.length() == 0) {
            return "-1";
        }
        
        return sb.toString();
    }
}
