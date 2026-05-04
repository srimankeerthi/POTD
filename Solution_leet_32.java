class Solution_leet_32{
    public boolean isBinaryPalindrome(int n) {
        int reversedN = 0;
        int temp = n;

        while (temp > 0) {
            // Shift reversedN left and add the rightmost bit of temp
            reversedN = (reversedN << 1) | (temp & 1);
            
            // Shift temp right to process the next bit
            temp = temp >> 1;
        }

        // If reversed bits match original number, it's a palindrome
        return reversedN == n;
    }
}
