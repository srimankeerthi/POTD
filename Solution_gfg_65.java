import java.util.Arrays;

class Solution_gfg_65 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Sort asteroids in ascending order to apply the greedy approach
        Arrays.sort(asteroids);
        
        // Use a long variable to prevent potential integer overflow during accumulation
        long currentMass = mass;
        
        for (int asteroid : asteroids) {
            // If the planet's mass is smaller than the current asteroid, it gets destroyed
            if (currentMass < asteroid) {
                return false;
            }
            // Otherwise, destroy the asteroid and absorb its mass
            currentMass += asteroid;
        }
        
        return true;
    }
}
