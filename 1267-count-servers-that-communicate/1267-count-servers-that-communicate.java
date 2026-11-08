class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        // iterating through matrix
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }

        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && row[i] + col[j] > 2){
                    ans++;
                }
            }
        }

        return ans;
    }
}