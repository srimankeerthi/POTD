class Solution_gfg_55 {
    public boolean isBitSet(int n) {
        // Base case: 0 does not have any set bits
        if (n == 0) {
            return false;
        }
        
        // If all bits are set, (n & (n + 1)) will always be 0
        return (n & (n + 1)) == 0;
    }
}
