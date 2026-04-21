class Solution_gfg_22{
    public int minSteps(int m, int n, int d) {
        // 1. Check if d is reachable
        if (d > Math.max(m, n) || d % gcd(m, n) != 0) {
            return -1;
        }

        // Return the minimum of the two possible pouring sequences
        return Math.min(simulate(m, n, d), simulate(n, m, d));
    }

    // Standard GCD function
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Simulates filling 'from' and pouring into 'to' until 'd' is reached
    private int simulate(int fromCap, int toCap, int d) {
        int from = fromCap; // Fill the first jug
        int to = 0;
        int steps = 1;

        while (from != d && to != d) {
            // Find how much we can pour
            int temp = Math.min(from, toCap - to);

            // Pour from 'from' to 'to'
            to += temp;
            from -= temp;
            steps++;

            if (from == d || to == d) break;

            // If 'from' becomes empty, fill it
            if (from == 0) {
                from = fromCap;
                steps++;
            }
            // If 'to' becomes full, empty it
            else if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }
}
