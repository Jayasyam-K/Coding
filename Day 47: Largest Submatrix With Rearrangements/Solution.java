class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];

        // 1. Calculate the height of consecutive 1s for each column
        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    height[i][j] = height[i - 1][j] + 1;
            }
        }

        int result = 0;
        // 2. Sort heights in each row and calculate max area
        for (int i = 0; i < m; i++) {
            Arrays.sort(height[i]);
            for (int j = 0; j < n; j++) {
                // height[i][j] is the min height for (n - j) columns
                result = Math.max(result, height[i][j] * (n - j));
            }
        }

        return result;
    }
}