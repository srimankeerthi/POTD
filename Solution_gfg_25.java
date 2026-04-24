class Solution_gfg_25 {
    public int visibleBuildings(int arr[]) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int count = 0;
        int maxHeightSoFar = 0;

        for (int height : arr) {
            // If the current building is taller than or equal to 
            // the tallest building seen so far, it gets sunlight.
            if (height >= maxHeightSoFar) {
                count++;
                maxHeightSoFar = height;
            }
        }

        return count;
    }
}
