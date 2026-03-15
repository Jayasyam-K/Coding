class Fancy {
    long a = 1, b = 0;
    long mod = 1000000007;
    List<Long> v = new ArrayList<>();

    public Fancy() {}

    public void append(int val) {
        v.add(((val - b + mod) % mod) * inv(a) % mod);
    }

    public void addAll(int inc) { b = (b + inc) % mod; }

    public void multAll(int m) {
        a = (a * m) % mod;
        b = (b * m) % mod;
    }

    public int getIndex(int idx) {
        if (idx >= v.size()) return -1;
        return (int) ((a * v.get(idx) + b) % mod);
    }

    private long inv(long x) { return pow(x, mod - 2); }

    private long pow(long x, long y) {
        long res = 1; x %= mod;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % mod;
            x = (x * x) % mod;
            y >>= 1;
        }
        return res;
    }
}
/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */