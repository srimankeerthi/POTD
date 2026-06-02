import java.util.Arrays;

class Solution_gfg_67 {
    public int sumDiffPairs(int[] arr, int k) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);
        
        int maxSum = 0;
        int i = arr.length - 1;
        
        // Step 2: Traverse from the largest elements to the smallest
        while (i > 0) {
            // Check if the current element and its neighbor satisfy the condition
            if (arr[i] - arr[i - 1] < k) {
                maxSum += arr[i] + arr[i - 1];
                i -= 2; // Move past both paired elements
            } else {
                i -= 1; // Move to the next potential element
            }
        }
        
        return maxSum;
    }
}
