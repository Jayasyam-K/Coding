class Solution {
    public boolean hasAlternatingBits(int n) {
        int current = n%2;
        n = n/2;
        while(n>0){
            if(current == n%2) return false;
            current = n%2;
            n=n/2;
        }
        return true;
    }
}