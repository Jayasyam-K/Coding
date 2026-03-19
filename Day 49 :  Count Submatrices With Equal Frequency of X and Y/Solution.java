class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, ans = 0;
        int[][][] dp = new int[rows + 1][cols + 1][2];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int isX = grid[r][c] == 'X' ? 1 : 0;
                int isY = grid[r][c] == 'Y' ? 1 : 0;
                
                int xCount = isX + dp[r][c+1][0] + dp[r+1][c][0] - dp[r][c][0];
                int yCount = isY + dp[r][c+1][1] + dp[r+1][c][1] - dp[r][c][1];
                
                dp[r+1][c+1][0] = xCount; dp[r+1][c+1][1] = yCount;
                if (xCount > 0 && xCount == yCount) ans++;
            }
        }
        return ans;
    }
}