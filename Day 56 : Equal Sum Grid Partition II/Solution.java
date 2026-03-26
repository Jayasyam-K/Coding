class Solution {
    public boolean canPartitionGrid(int[][] grid) {
if (check(grid)) return true;
        int m = grid.length, n = grid[0].length;
        int[][] transposed = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) transposed[j][i] = grid[i][j];
        }
        return check(transposed);
    }
    
    private boolean check(int[][] g) {
        int m = g.length, n = g[0].length;
        if (m < 2) return false;
        
        Map<Integer, Integer> botFreq = new HashMap<>();
        long tot = 0;
        long[] rowSums = new long[m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                botFreq.put(g[r][c], botFreq.getOrDefault(g[r][c], 0) + 1);
                rowSums[r] += g[r][c];
                tot += g[r][c];
            }
        }
        
        Map<Integer, Integer> topFreq = new HashMap<>();
        long topSum = 0;
        
        for (int r = 1; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int v = g[r-1][c];
                topFreq.put(v, topFreq.getOrDefault(v, 0) + 1);
                botFreq.put(v, botFreq.get(v) - 1);
                if (botFreq.get(v) == 0) botFreq.remove(v);
            }
            
            topSum += rowSums[r-1];
            long botSum = tot - topSum;
            if (topSum == botSum) return true;
            
            long diff = Math.abs(topSum - botSum);
            if (diff > Integer.MAX_VALUE) continue; 
            int d = (int) diff;
            
            if (topSum > botSum) {
                if (r == 1) {
                    if (d == g[0][0] || d == g[0][n-1]) return true;
                } else if (n == 1) {
                    if (d == g[0][0] || d == g[r-1][0]) return true;
                } else if (topFreq.containsKey(d)) return true;
            } else {
                int botRows = m - r;
                if (botRows == 1) {
                    if (d == g[r][0] || d == g[r][n-1]) return true;
                } else if (n == 1) {
                    if (d == g[r][0] || d == g[m-1][0]) return true;
                } else if (botFreq.containsKey(d)) return true;
            }
        }
        return false;
    }
}