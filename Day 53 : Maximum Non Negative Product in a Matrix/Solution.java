class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] maxgt = new long[m][n], minlt = new long[m][n];
        maxgt[0][0] = minlt[0][0] = grid[0][0];

        for (int i = 1; i < n; i++)
            maxgt[0][i] = minlt[0][i] = maxgt[0][i - 1] * grid[0][i];
        for (int i = 1; i < m; i++)
            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i - 1][j], maxgt[i][j - 1]) * grid[i][j];
                    minlt[i][j] = Math.min(minlt[i - 1][j], minlt[i][j - 1]) * grid[i][j];
                } else {
                    maxgt[i][j] = Math.min(minlt[i - 1][j], minlt[i][j - 1]) * grid[i][j];
                    minlt[i][j] = Math.max(maxgt[i - 1][j], maxgt[i][j - 1]) * grid[i][j];
                }
            }
        }
        long result = maxgt[m - 1][n - 1];
        return result < 0 ? -1 : (int) (result % 1000000007);
    }
}