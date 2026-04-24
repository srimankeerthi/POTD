class Solution_leet_25 {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countUnderscore = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countR++;
            } else {
                countUnderscore++;
            }
        }

        // The logic: abs(L - R) + count of '_'
        return Math.abs(countL - countR) + countUnderscore;
    }
}
