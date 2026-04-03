import java.util.*;

class Solution_leet_5 {

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        // map robot position -> distance
        Map<Integer, Integer> reach = new HashMap<>();
        for (int i = 0; i < n; i++) {
            reach.put(robots[i], distance[i]);
        }

        Arrays.sort(robots);
        Arrays.sort(walls);

        int[] leftCounts = computeLeftCounts(robots, walls, reach);
        int[] rightCounts = computeRightCounts(robots, walls, reach);
        int[] betweenCounts = computeBetweenCounts(robots, walls);

        return dp(n, leftCounts, rightCounts, betweenCounts);
    }

    private int leftBoundary(int i, int[] robots, Map<Integer, Integer> reach) {
        int rawLeft = robots[i] - reach.get(robots[i]);
        if (i >= 1) {
            return Math.max(rawLeft, robots[i - 1] + 1);
        }
        return rawLeft;
    }

    private int rightBoundary(int i, int[] robots, Map<Integer, Integer> reach) {
        int n = robots.length;
        int rawRight = robots[i] + reach.get(robots[i]);
        if (i < n - 1) {
            return Math.min(rawRight, robots[i + 1] - 1);
        }
        return rawRight;
    }

    private int[] computeLeftCounts(int[] robots, int[] walls, Map<Integer, Integer> reach) {
        int n = robots.length;
        int[] leftCounts = new int[n];

        for (int i = 0; i < n; i++) {
            int wallAtRobot = upperBound(walls, robots[i]);
            int leftBound = leftBoundary(i, robots, reach);
            int wallAtLeftBound = lowerBound(walls, leftBound);
            leftCounts[i] = wallAtRobot - wallAtLeftBound;
        }

        return leftCounts;
    }

    private int[] computeRightCounts(int[] robots, int[] walls, Map<Integer, Integer> reach) {
        int n = robots.length;
        int[] rightCounts = new int[n];

        for (int i = 0; i < n; i++) {
            int rightBound = rightBoundary(i, robots, reach);
            int wallAtRightBound = upperBound(walls, rightBound);
            int wallAtRobot = lowerBound(walls, robots[i]);
            rightCounts[i] = wallAtRightBound - wallAtRobot;
        }

        return rightCounts;
    }

    private int[] computeBetweenCounts(int[] robots, int[] walls) {
        int n = robots.length;
        int[] betweenCounts = new int[n];

        for (int i = 1; i < n; i++) {
            int wallAfterCurrent = upperBound(walls, robots[i]);
            int wallAtPrevious = lowerBound(walls, robots[i - 1]);
            betweenCounts[i] = wallAfterCurrent - wallAtPrevious;
        }

        return betweenCounts;
    }

    private int dp(int n, int[] leftCounts, int[] rightCounts, int[] betweenCounts) {
        int dpLeft = leftCounts[0];
        int dpRight = rightCounts[0];

        for (int i = 1; i < n; i++) {
            int sharedCap = Math.min(leftCounts[i] + rightCounts[i - 1], betweenCounts[i]);

            int newLeft = Math.max(
                dpLeft + leftCounts[i],
                dpRight - rightCounts[i - 1] + sharedCap
            );

            int newRight = Math.max(
                dpLeft + rightCounts[i],
                dpRight + rightCounts[i]
            );

            dpLeft = newLeft;
            dpRight = newRight;
        }

        return Math.max(dpLeft, dpRight);
    }

    // lower_bound → first index >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // upper_bound → first index > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}