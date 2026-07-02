class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[2] - a[2]);

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        int[][] best = new int[m][n];
        best[0][0] = startHealth;

        pq.offer(new int[]{0, 0, startHealth});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int h = cur[2];

            if (x == m - 1 && y == n - 1)
                return true;

            if (h < best[x][y])
                continue;

            for (int[] d : DIRS) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                int nh = h - grid.get(nx).get(ny);

                if (nh > best[nx][ny] && nh >= 1) {
                    best[nx][ny] = nh;
                    pq.offer(new int[]{nx, ny, nh});
                }
            }
        }

        return false;
    }
}