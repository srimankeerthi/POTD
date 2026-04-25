import java.util.*;

class Solution_leet_26 {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] linearPoints = new long[n];
        
        // Step 1: Map 2D points to 1D perimeter positions
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (y == 0) {
                linearPoints[i] = x;
            } else if (x == side) {
                linearPoints[i] = (long)side + y;
            } else if (y == side) {
                linearPoints[i] = (long)2 * side + (side - x);
            } else {
                linearPoints[i] = (long)3 * side + (side - y);
            }
        }
        
        Arrays.sort(linearPoints);
        long perimeter = 4L * side;
        
        // Step 2: Binary Search for the maximum possible minimum distance
        int low = 1, high = side;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(linearPoints, k, mid, perimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canPlace(long[] pts, int k, int d, long perimeter) {
        int n = pts.length;
        // Optimization: We only need to check starting points in the first "gap"
        for (int i = 0; i < n; i++) {
            if (pts[i] > pts[0] + d) break; 
            
            int count = 1;
            long lastPos = pts[i];
            int currIdx = i;
            
            for (int j = 1; j < k; j++) {
                long target = lastPos + d;
                int nextIdx = lowerBound(pts, target);
                
                if (nextIdx < n) {
                    lastPos = pts[nextIdx];
                    currIdx = nextIdx;
                    count++;
                } else {
                    break;
                }
            }
            
            // Check circular distance between last and first point
            if (count == k && (perimeter - (pts[currIdx] - pts[i])) >= d) {
                return true;
            }
        }
        return false;
    }
    
    private int lowerBound(long[] pts, long target) {
        int l = 0, r = pts.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (pts[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
