class Solution {
    public int bitwiseComplement(int n) {
        //Base case where if n =0 , we need to flip it to 1 
        if(n == 0) return 1;

        int mask = 1;
        //Building mask as the same length as n
        while(mask < n){
            mask = (mask << 1) | 1;
        }
        //XOR operation
        return n^mask;
    }
}