class Solution_gfg_72{
    public String profession(int level, int pos) {
        boolean isFlipped = false;
        
        // Trace up the tree from the position to the root
        while (pos > 1) {
            // If the current position is even, it means it's a second child (flipped)
            if (pos % 2 == 0) {
                isFlipped = !isFlipped;
            }
            // Move to the parent's position
            pos = (pos + 1) / 2;
        }
        
        // Root is always Engineer. If flipped an odd number of times, it's a Doctor.
        if (isFlipped) {
            return "Doctor";
        } else {
            return "Engineer";
        }
    }
}
