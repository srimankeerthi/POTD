class Solution_leet_71{

    static class Pair {
        long cnt;
        long wav;

        Pair(long c, long w) {
            cnt = c;
            wav = w;
        }
    }

    private String s;
    private Pair[][] memo;
    private boolean[][] seen;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        s = String.valueOf(n);

        int states = 3 * 11 * 11;
        memo = new Pair[s.length()][states];
        seen = new boolean[s.length()][states];

        return dfs(0, true, 0, 10, 10).wav;
    }

    private int encode(int len, int prev2, int prev1) {
        return len * 121 + prev2 * 11 + prev1;
    }

    private Pair dfs(int pos, boolean tight,
                     int len, int prev2, int prev1) {

        if (pos == s.length()) {
            return new Pair(1, 0);
        }

        int key = encode(len, prev2, prev1);

        if (!tight && seen[pos][key]) {
            return memo[pos][key];
        }

        int limit = tight ? s.charAt(pos) - '0' : 9;

        long totalCnt = 0;
        long totalWav = 0;

        for (int d = 0; d <= limit; d++) {

            boolean ntight = tight && (d == limit);

            int nLen, nPrev2, nPrev1;
            int add = 0;

            if (len == 0) {

                if (d == 0) {
                    nLen = 0;
                    nPrev2 = 10;
                    nPrev1 = 10;
                } else {
                    nLen = 1;
                    nPrev2 = 10;
                    nPrev1 = d;
                }

            } else if (len == 1) {

                nLen = 2;
                nPrev2 = prev1;
                nPrev1 = d;

            } else {

                if ((prev1 > prev2 && prev1 > d) ||
                    (prev1 < prev2 && prev1 < d)) {
                    add = 1;
                }

                nLen = 2;
                nPrev2 = prev1;
                nPrev1 = d;
            }

            Pair nxt = dfs(pos + 1, ntight,
                           nLen, nPrev2, nPrev1);

            totalCnt += nxt.cnt;
            totalWav += nxt.wav + (long) add * nxt.cnt;
        }

        Pair ans = new Pair(totalCnt, totalWav);

        if (!tight) {
            seen[pos][key] = true;
            memo[pos][key] = ans;
        }

        return ans;
    }
}
