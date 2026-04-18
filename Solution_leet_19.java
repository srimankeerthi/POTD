class Solution_leet_19 {
    public int mirrorDistance(int n) {
        // Store the original number to calculate the difference later
        long original = n;
        long reversed = 0;
        long temp = n;
        
        // Reverse the integer
        while (temp > 0) {
            reversed = reversed * 10 + (temp % 10);
            temp /= 10;
        }
        
        // Return the absolute difference
        // Use Math.abs and cast back to int as per the problem signature
        return (int) Math.abs(original - reversed);
    }
}
