class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";
        char[] result = new char[n];
        int startA = 1, startB = startA + (1 << (n - 1)), startC = startB + (1 << (n - 1));
        if (k < startB) { result[0] = 'a'; k -= startA; }
        else if (k < startC) { result[0] = 'b'; k -= startB; }
        else { result[0] = 'c'; k -= startC; }
        char[][] nextChoices = {
            {'b', 'c'}, // if prev is 'a'
            {'a', 'c'}, // if prev is 'b'
            {'a', 'b'}  // if prev is 'c'
        };
        for (int i = 1; i < n; i++) {
            int midpoint = 1 << (n - i - 1);
            int prevIdx = result[i - 1] - 'a';
            if (k < midpoint) { result[i] = nextChoices[prevIdx][0]; }
            else { result[i] = nextChoices[prevIdx][1]; k -= midpoint; }
        }
        return new String(result);
    }
}