class Solution_leet_54{
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        // Frequency array to keep track of element counts. 
        // Size is n + 1 because the numbers are 1-indexed (from 1 to n).
        int[] freq = new int[n + 1];
        
        int commonCount = 0;
        
        for (int i = 0; i < n; i++) {
            // Increment frequency for the element in array A
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                commonCount++;
            }
            
            // Increment frequency for the element in array B
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                commonCount++;
            }
            
            // Assign the running count to our result array
            result[i] = commonCount;
        }
        
        return result;
    }
}
