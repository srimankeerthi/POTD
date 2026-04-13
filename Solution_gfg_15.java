class Solution_gfg_15 {
    // 1. Change return type from ArrayList<Integer> to int[]
    // 2. Ensure parameters match what the driver code calls: (int num[])
    int[] nextPalindrome(int num[]) {
        int n = num.length;
        
        // Handle all 9s case
        boolean allNine = true;
        for (int i = 0; i < n; i++) {
            if (num[i] != 9) {
                allNine = false;
                break;
            }
        }
        
        if (allNine) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        // Standard Palindrome Logic
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        int left = i, right = j;
        while (left >= 0 && num[left] == num[right]) {
            left--;
            right++;
        }

        boolean mustIncrement = false;
        if (left < 0 || num[left] < num[right]) {
            mustIncrement = true;
        }

        // Mirror left to right
        while (i >= 0) {
            num[j] = num[i];
            i--; j++;
        }

        // Increment if necessary
        if (mustIncrement) {
            int carry = 1;
            int midIdx = (n - 1) / 2;
            for (int k = midIdx; k >= 0 && carry > 0; k--) {
                num[k] += carry;
                carry = num[k] / 10;
                num[k] %= 10;
                num[n - 1 - k] = num[k];
            }
        }

        return num; // Return the modified int[] array
    }
}
