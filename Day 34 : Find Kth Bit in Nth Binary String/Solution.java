class Solution {
    public char findKthBit(int n, int k) {
        int length = (1 << n) - 1;
        boolean invert = false;

        while (length > 1) {
            int half = length / 2;
            if (k <= half) {
                length = half;
            } else if (k == half + 1) {
                return invert ? '0' : '1';
            } else {
                k = length - k + 1;
                length = half;
                invert = !invert;
            }
        }

        return invert ? '1' : '0';
    }
}