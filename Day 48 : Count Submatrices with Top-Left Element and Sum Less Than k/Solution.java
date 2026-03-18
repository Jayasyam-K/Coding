class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int[][] pref = new int[m+1][n+1];
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                pref[r+1][c+1] = grid[r][c] + pref[r][c+1] + pref[r+1][c] - pref[r][c];
                if(pref[r+1][c+1] <= k){
                    result++;
                }
                //if the sum exceeds "k" then we can giveUp on that row
                else break;
            }
        }
        return result;
    }
}