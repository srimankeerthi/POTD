import java.util.ArrayList;

class Solution_leet_46 {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;
        int m = b.length;

        // Edge case: pattern is longer than the array
        if (m > n) return result;

        // Step 1: Create the LPS array for pattern b
        int[] lps = computeLPSArray(b);

        int i = 0; // index for a[]
        int j = 0; // index for b[]

        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == m) {
                // Found a match, add the starting index
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && a[i] != b[j]) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private int[] computeLPSArray(int[] b) {
        int m = b.length;
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
