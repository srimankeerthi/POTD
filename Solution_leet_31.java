class Solution_leet_31 {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(int n) {
        boolean hasRotatingDigit = false;
        while (n > 0) {
            int digit = n % 10;
            // If it contains any invalid digits, it's not good
            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            // Check if it contains at least one digit that changes the number
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasRotatingDigit = true;
            }
            n /= 10;
        }
        return hasRotatingDigit;
    }
}
