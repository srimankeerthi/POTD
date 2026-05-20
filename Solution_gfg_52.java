import java.util.HashSet;

class Solution_gfg_52 {
    public boolean isProduct(int[] arr, long target) {
        HashSet<Long> seen = new HashSet<>();
        
        for (int num : arr) {
            long x = (long) num;
            
            // Handle the case where target is 0
            if (target == 0) {
                if (x == 0 && !seen.isEmpty()) {
                    return true;
                }
                if (seen.contains(0L)) {
                    return true;
                }
            } else {
                // target is not 0, so x cannot be 0 if it's a valid factor
                if (x != 0 && target % x == 0) {
                    long required = target / x;
                    if (seen.contains(required)) {
                        return true;
                    }
                }
            }
            
            seen.add(x);
        }
        
        return false;
    }
}
