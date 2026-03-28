class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        int[] charGroup = new int[n];
        charGroup[0] = 0;  

        for (int i = 1; i < n; i++) {
            int forbiddenMask = 0;
            int assignedGroup = -1;

            for (int j = 0; j < i; j++) {
                if (lcp[i][j] > 0) {
                    assignedGroup = charGroup[j];
                    break;
                } else if (lcp[i][j] == 0) {
                    forbiddenMask |= 1 << charGroup[j];
                }
            }

            if (assignedGroup != -1) {
                charGroup[i] = assignedGroup;
            } else {
                int chosenChar = 0;
                while (chosenChar < 26 && ((forbiddenMask >> chosenChar) & 1) == 1) {
                    chosenChar++;
                }
                if (chosenChar >= 26) return "";
                charGroup[i] = chosenChar;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (charGroup[i] != charGroup[j]) {
                    if (lcp[i][j] != 0) return "";
                } else {
                    if (i == n - 1 || j == n - 1) {
                        if (lcp[i][j] != 1) return "";
                    } else {
                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) return "";
                    }
                }
            }
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = (char) ('a' + charGroup[i]);
        }

        return new String(result);
    }
}