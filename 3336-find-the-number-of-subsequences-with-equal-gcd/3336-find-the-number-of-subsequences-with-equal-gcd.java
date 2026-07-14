class Solution {

    static final int MAX = 200;
    static final int MOD = 1_000_000_007;

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public int subsequencePairCount(int[] nums) {

        int[][] gcdDP = new int[MAX + 1][MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                gcdDP[i][j] = gcd(i, j);
            }
        }

        long[][] dp = new long[MAX + 1][MAX + 1];
        dp[0][0] = 1;

        for (int num : nums) {

            long[][] next = new long[MAX + 1][MAX + 1];

            for (int g1 = 0; g1 <= MAX; g1++) {

                long[] dpRow = dp[g1];
                long[] nextRow = next[g1];

                for (int g2 = 0; g2 <= MAX; g2++) {

                    long cur = dpRow[g2];
                    if (cur == 0) continue;

                    // Skip
                    nextRow[g2] = (nextRow[g2] + cur) % MOD;

                    // Put in first subsequence
                    int ng1 = gcdDP[g1][num];
                    next[ng1][g2] = (next[ng1][g2] + cur) % MOD;

                    // Put in second subsequence
                    int ng2 = gcdDP[g2][num];
                    nextRow[ng2] = (nextRow[ng2] + cur) % MOD;
                }
            }

            dp = next; // Swap instead of copying
        }

        long ans = 0;
        for (int g = 1; g <= MAX; g++) {
            ans += dp[g][g];
            if (ans >= MOD) ans -= MOD;
        }

        return (int) ans;
    }
}