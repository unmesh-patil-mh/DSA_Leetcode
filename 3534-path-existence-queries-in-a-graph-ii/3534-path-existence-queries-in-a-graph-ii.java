import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        // Store (value,index) in one long
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (((long) nums[i]) << 32) | (i & 0xffffffffL);
        }

        Arrays.sort(arr);

        int[] values = new int[n];
        int[] point = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = (int) (arr[i] >> 32);
            point[(int) arr[i]] = i;
        }

        // Sliding window
        int[] up = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j + 1 < n && values[j + 1] - values[i] <= maxDiff) {
                j++;
            }
            if (j < i) j = i;
            up[i] = j;
        }

        int LOG = 32 - Integer.numberOfLeadingZeros(n);

        int[][] dp = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            dp[i][0] = up[i];
        }

        for (int b = 1; b < LOG; b++) {
            for (int i = 0; i < n; i++) {
                dp[i][b] = dp[dp[i][b - 1]][b - 1];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int qi = 0; qi < m; qi++) {

            int u = point[queries[qi][0]];
            int v = point[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            int st, en;
            if (u < v) {
                st = u;
                en = v;
            } else {
                st = v;
                en = u;
            }

            if (up[st] == st) {
                ans[qi] = -1;
                continue;
            }

            int node = st;
            int jumps = 0;

            for (int b = LOG - 1; b >= 0; b--) {
                int nxt = dp[node][b];
                if (nxt < en) {
                    node = nxt;
                    jumps += 1 << b;
                }
            }

            ans[qi] = (up[node] >= en) ? jumps + 1 : -1;
        }

        return ans;
    }
}