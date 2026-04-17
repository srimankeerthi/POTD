class Solution_gfg_16{
    String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Append only if the character is not a space
            if (ch != ' ') {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}
