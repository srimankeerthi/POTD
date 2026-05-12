import java.util.Arrays;

class Solution_leet_42{
    public int minimumEffort(int[][] tasks) {
        // Sort tasks based on the difference (minimum - actual) in descending order
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int currentEnergy = 0;
        int totalInitialEnergy = 0;
        
        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];
            
            // If current energy is less than what's required to start the task
            if (currentEnergy < minimum) {
                // Add the deficit to our total initial energy
                totalInitialEnergy += (minimum - currentEnergy);
                // After adding the deficit, our current energy becomes the minimum required
                currentEnergy = minimum;
            }
            
            // Spend the actual energy required for the task
            currentEnergy -= actual;
        }
        
        return totalInitialEnergy;
    }
}
