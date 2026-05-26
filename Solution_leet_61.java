class Solution_leet_61{
    int minToggle(int[] arr) {
        int ones = 0;
        int toggles = 0;
        
        for (int num : arr) {
            if (num == 1) {
                // Encountered a 1, increment our 1s counter
                ones++;
            } else {
                // Encountered a 0, decide the cheaper option:
                // 1. Flip this 0 to 1 -> toggles + 1
                // 2. Keep this 0, flip all previous 1s -> ones
                toggles = Math.min(toggles + 1, ones);
            }
        }
        
        return toggles;
    }
}
