import java.util.*;

class Solution_gfg_26{
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int val : arr) {
            boolean destroyed = false;
            
            // Logic change: Check if signs are opposite (one pos, one neg)
            while (!stack.isEmpty() && (stack.peek() > 0 != val > 0)) {
                int topAbs = Math.abs(stack.peek());
                int currAbs = Math.abs(val);
                
                if (topAbs < currAbs) {
                    // Top is smaller, remove it and keep checking against the NEW top
                    stack.pop();
                } else if (topAbs == currAbs) {
                    // Both are equal, both are removed
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current is smaller, current is destroyed
                    destroyed = true;
                    break;
                }
            }
            
            if (!destroyed) {
                stack.push(val);
            }
        }

        return new ArrayList<>(stack);
    }
}
