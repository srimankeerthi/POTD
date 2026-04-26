class Solution_gfg_26 {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        
        while (i < a.length && j < b.length && k < c.length) {
            // Found a common element
            if (a[i] == b[j] && b[j] == c[k]) {
                res.add(a[i]);
                int common = a[i];
                
                // Skip duplicates in all three arrays
                while (i < a.length && a[i] == common) i++;
                while (j < b.length && b[j] == common) j++;
                while (k < c.length && c[k] == common) k++;
            } 
            // Move the pointer that points to the smallest element
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }
        return res;
    }
}
