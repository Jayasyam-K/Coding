class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] s = new char[n + m - 1];
        boolean[] fixed = new boolean[n + m - 1];
        for (int i = 0; i < s.length; i++) s[i] = 'a';
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int pos = i + j;
                    if (fixed[pos] && s[pos] != str2.charAt(j)) return "";
                    s[pos] = str2.charAt(j);
                    fixed[pos] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean diff = false;
                for (int j = 0; j < m; j++) {
                    if (s[i + j] != str2.charAt(j)) {
                        diff = true; break;
                    }
                }
                if (diff) continue;
                boolean changed = false;
                for (int j = m - 1; j >= 0; j--) {
                    int pos = i + j;
                    if (!fixed[pos]) {
                        s[pos] = 'b'; changed = true; break;
                    }
                }
                if (!changed) return "";
            }
        }
        return new String(s);
    }
}