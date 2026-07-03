class Solution {

    private boolean check(int minEdge, List<int[]>[] adj, int[] topo,
                          boolean[] online, long k, int n) {

        final long INF = Long.MAX_VALUE;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int idx = 0; idx < n; idx++) {
            int u = topo[idx];

            long du = dist[u];
            if (du == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            List<int[]> list = adj[u];
            for (int i = 0, sz = list.size(); i < sz; i++) {
                int[] e = list.get(i);

                if (e[1] < minEdge) continue;

                int v = e[0];
                if (v != n - 1 && !online[v]) continue;

                long nd = du + e[1];
                if (nd < dist[v]) dist[v] = nd;
            }
        }

        return dist[n - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int[] indegree = new int[n];
        int maxEdge = 0;

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            if (e[2] > maxEdge) maxEdge = e[2];
        }

        int[] topo = new int[n];
        int[] queue = new int[n];

        int head = 0, tail = 0, idx = 0;

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                queue[tail++] = i;

        while (head < tail) {
            int u = queue[head++];
            topo[idx++] = u;

            List<int[]> list = adj[u];
            for (int i = 0, sz = list.size(); i < sz; i++) {
                int v = list.get(i)[0];
                if (--indegree[v] == 0)
                    queue[tail++] = v;
            }
        }

        int lo = 0, hi = maxEdge, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (check(mid, adj, topo, online, k, n)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}