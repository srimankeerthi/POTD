class Solution_leet_69 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
            solveOneWay(landStartTime, landDuration, waterStartTime, waterDuration),
            solveOneWay(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int solveOneWay(int[] firstStart, int[] firstDuration, int[] secondStart, int[] secondDuration) {
        // Step 1: Find the absolute earliest finish time for the first category
        int bestFirstFinish = Integer.MAX_VALUE;
        for (int i = 0; i < firstStart.length; i++) {
            bestFirstFinish = Math.min(bestFirstFinish, firstStart[i] + firstDuration[i]);
        }

        // Step 2: Find the best second ride to pair with it
        int minTotalFinish = Integer.MAX_VALUE;
        for (int j = 0; j < secondStart.length; j++) {
            int currentFinish = Math.max(bestFirstFinish, secondStart[j]) + secondDuration[j];
            minTotalFinish = Math.min(minTotalFinish, currentFinish);
        }

        return minTotalFinish;
    }
}
