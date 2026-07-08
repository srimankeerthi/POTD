class Solution_leet_75 {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        int MOD = 1000000007;

        // Step 1: Extract non-zero digits and their original positions
        int[] nzDigits = new int[m];
        int[] nzPositions = new int[m];
        int nzCount = 0;

        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                nzDigits[nzCount] = ch - '0';
                nzPositions[nzCount] = i;
                nzCount++;
            }
        }

        // Step 2: Precompute prefix sums, prefix values, and powers of 10
        long[] prefSum = new long[nzCount + 1];
        long[] prefVal = new long[nzCount + 1];
        long[] pow10 = new long[nzCount + 1];
        
        pow10[0] = 1;
        for (int i = 0; i < nzCount; i++) {
            prefSum[i + 1] = prefSum[i] + nzDigits[i];
            prefVal[i + 1] = (prefVal[i] * 10 + nzDigits[i]) % MOD;
            pow10[i + 1] = (pow10[i] * 10) % MOD;
        }

        // Step 3: Map original string indices to compressed non-zero indices
        int[] next_nz = new int[m];
        int curr = 0;
        for (int i = 0; i < m; i++) {
            while (curr < nzCount && nzPositions[curr] < i) {
                curr++;
            }
            next_nz[i] = curr; // pointer to the first nz >= i
        }

        int[] prev_nz = new int[m];
        curr = nzCount - 1;
        for (int i = m - 1; i >= 0; i--) {
            while (curr >= 0 && nzPositions[curr] > i) {
                curr--;
            }
            prev_nz[i] = curr; // pointer to the last nz <= i
        }

        // Step 4: Process each query
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int idxL = next_nz[l];
            int idxR = prev_nz[r];

            // If there are no non-zero digits in the range s[l..r]
            if (idxL > idxR || idxL >= nzCount || idxR < 0) {
                answer[i] = 0;
                continue;
            }

            // Calculate sum of digits
            long sum = prefSum[idxR + 1] - prefSum[idxL];

            // Calculate x using prefix values
            long x = (prefVal[idxR + 1] - (prefVal[idxL] * pow10[idxR - idxL + 1]) % MOD + MOD) % MOD;

            // Combine and take modulo
            answer[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return answer;
    }
}
