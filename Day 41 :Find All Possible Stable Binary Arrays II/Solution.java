class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int mod = 1000000007;
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                for (int lastBit = 0; lastBit < 2; lastBit++) {
                    if (i == 0) {
                        dp[i][j][lastBit] = (lastBit == 0 || j > limit) ? 0 : 1;
                    } else if (j == 0) {
                        dp[i][j][lastBit] = (lastBit == 1 || i > limit) ? 0 : 1;
                    } else if (lastBit == 0) {
                        dp[i][j][lastBit] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod;
                        if (i > limit) {
                            dp[i][j][lastBit] = (dp[i][j][lastBit] - dp[i - 1 - limit][j][1] + mod) % mod;
                        }
                    } else {
                        dp[i][j][lastBit] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % mod;
                        if (j > limit) {
                            dp[i][j][lastBit] = (dp[i][j][lastBit] - dp[i][j - 1 - limit][0] + mod) % mod;
                        }
                    }
                }
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % mod);
    }
}