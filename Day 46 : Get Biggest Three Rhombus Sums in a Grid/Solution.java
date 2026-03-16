class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum1 = new int[m + 2][n + 2];
        int[][] sum2 = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum1[i][j] = sum1[i - 1][j - 1] + grid[i - 1][j - 1];
                sum2[i][j] = sum2[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                set.add(grid[r][c]);
                for (int L = 1; L < Math.min(m, n); L++) {
                    if (r + 2 * L >= m || c - L < 0 || c + L >= n)
                        break;
                    int edge1 = sum2[r + L + 1][c - L + 1] - sum2[r + 1][c + 1];
                    int edge2 = sum1[r + 2 * L + 1][c + 1] - sum1[r + L + 1][c - L + 1];
                    int edge3 = sum1[r + L + 1][c + L + 1] - sum1[r + 1][c + 1];
                    int edge4 = sum2[r + 2 * L + 1][c + 1] - sum2[r + L + 1][c + L + 1];
                    set.add(edge1 + edge2 + edge3 + edge4 + grid[r][c] - grid[r + 2 * L][c]);
                }
                while (set.size() > 3)
                    set.pollFirst();
            }
        }
        int[] ans = new int[set.size()];
        int idx = ans.length - 1;
        for (int val : set)
            ans[idx--] = val;
        return ans;
    }
}