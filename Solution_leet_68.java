class Solution_leet_68{
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        // Iterate through all pairs of land and water rides
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                // Option 1: Land ride first -> Water ride second
                int landFinish = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int option1Finish = waterStart + waterDuration[j];
                
                // Option 2: Water ride first -> Land ride second
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int option2Finish = landStart + landDuration[i];
                
                // Track the absolute earliest finish time
                minFinishTime = Math.min(minFinishTime, Math.min(option1Finish, option2Finish));
            }
        }

        return minFinishTime;
    }
}
