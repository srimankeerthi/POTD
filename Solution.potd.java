import java.util.*;

class Solution.potd {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // Step 1: store index and sort by position
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);

        Stack<Integer> stack = new Stack<>();

        for (int id : idx) {
            if (directions.charAt(id) == 'R') {
                stack.push(id);
            } else {
                // moving left
                while (!stack.isEmpty() && healths[id] > 0) {
                    int top = stack.peek();

                    if (healths[top] < healths[id]) {
                        // right robot dies
                        stack.pop();
                        healths[id] -= 1;
                        healths[top] = 0;
                    } else if (healths[top] > healths[id]) {
                        // left robot dies
                        healths[top] -= 1;
                        healths[id] = 0;
                        break;
                    } else {
                        // both die
                        stack.pop();
                        healths[top] = 0;
                        healths[id] = 0;
                        break;
                    }
                }
            }
        }

        // Collect survivors in original order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) result.add(healths[i]);
        }

        return result;
    }
}