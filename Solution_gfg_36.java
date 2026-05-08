class Solution_gfg_36{
    public List<String> validParenthesis(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> currentLevelValid = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (isValid(curr)) {
                    currentLevelValid.add(curr);
                    found = true;
                }

                // If we haven't found a valid string yet, keep generating neighbors
                if (!found) {
                    for (int j = 0; j < curr.length(); j++) {
                        // Skip lowercase letters, only remove parentheses
                        if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;

                        String next = curr.substring(0, j) + curr.substring(j + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }

            if (found) {
                // Remove duplicates and sort for lexicographical order
                Set<String> distinctSet = new HashSet<>(currentLevelValid);
                result.addAll(distinctSet);
                Collections.sort(result);
                return result;
            }
        }

        return result;
    }

    // Helper method to check if a string of parentheses is valid
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
