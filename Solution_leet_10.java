class Solution_leet_10{
    void segregate0and1(int[] arr) {
        int zeroCount = 0;
        
        // Count all zeros
        for (int num : arr) {
            if (num == 0) zeroCount++;
        }
        
        // Fill the first part with 0s and the rest with 1s
        for (int i = 0; i < arr.length; i++) {
            if (i < zeroCount) arr[i] = 0;
            else arr[i] = 1;
        }
    }
}
