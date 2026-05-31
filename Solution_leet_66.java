class Solution_leet_66{
    public boolean isSumOfConsecutive(int n) {
        // If n is a power of 2, it cannot be expressed as a sum of consecutive numbers.
        // Also, the problem specifies positive numbers, and n >= 1.
        return (n & (n - 1)) != 0;
    }
}
