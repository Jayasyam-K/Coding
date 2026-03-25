class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        if (totalSum % 2 != 0) return false;
        long target = totalSum / 2;

        long currentSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                currentSum += grid[i][j];
            }
            if (currentSum == target) return true;
        }

        currentSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                currentSum += grid[i][j];
            }
            if (currentSum == target) return true;
        }

        return false;
    }
}