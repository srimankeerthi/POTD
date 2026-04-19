class Solution_gfg_20 {
    public boolean isPower(int x, int y) {
        // Any number to the power of 0 is 1
        if (y == 1) return true;
        
        // If x is 1 and y is not 1, y can never be a power of x
        if (x == 1) return false;
        
        long power = x;
        
        // Keep multiplying until we reach or exceed y
        while (power < y) {
            power = power * x;
        }
        
        // Check if the final result matches y
        return (power == y);
    }
}
