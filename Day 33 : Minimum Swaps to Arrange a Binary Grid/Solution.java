class Solution {
    public int minSwaps(int[][] matrix) {
        int size = matrix.length;
        int[] rightMostOne = new int[size];

        for (int row = 0; row < size; row++) {
            rightMostOne[row] = -1;
            for (int col = size - 1; col >= 0; col--) {
                if (matrix[row][col] == 1) {
                    rightMostOne[row] = col;
                    break;
                }
            }
        }

        int swaps = 0;
        for (int targetRow = 0; targetRow < size; targetRow++) {
            int foundRow = -1;

            for (int currentRow = targetRow; currentRow < size; currentRow++) {
                if (rightMostOne[currentRow] <= targetRow) {
                    swaps += currentRow - targetRow;
                    foundRow = currentRow;
                    break;
                }
            }

            if (foundRow != -1) {
                for (int moveRow = foundRow; moveRow > targetRow; moveRow--) {
                    int temp = rightMostOne[moveRow];
                    rightMostOne[moveRow] = rightMostOne[moveRow - 1];
                    rightMostOne[moveRow - 1] = temp;
                }
            } else {
                return -1;
            }
        }

        return swaps;
    }
}