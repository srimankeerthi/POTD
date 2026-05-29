class Solution_leet_64 {
    public int minElement(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        
        for (int num : nums) {
            int digitSum = 0;
            int temp = num;
            
            // Calculate sum of digits
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            
            // Keep track of the minimum sum found
            if (digitSum < minVal) {
                minVal = digitSum;
            }
        }
        
        return minVal;
    }
}
