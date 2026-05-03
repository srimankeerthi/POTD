class Solution_ Leet_32{
    public boolean rotateString(String s, String goal) {
        // Step 1: Check if lengths match
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Step 2 & 3: Concatenate s with itself and check if goal exists within it
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
