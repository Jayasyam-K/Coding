class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int i0 = x;
        int i1 = x+k-1;
        while(i0 < i1){
            for(int j=y;j<y+k;j++){
                int temp = grid[i0][j];
                grid[i0][j]=grid[i1][j];
                grid[i1][j] = temp;
            }
            i0++;
            i1--;
        }
        return grid;
    }
}