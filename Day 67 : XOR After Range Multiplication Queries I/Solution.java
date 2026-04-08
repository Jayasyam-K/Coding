class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = 1000000007;
        for(int i=0;i<queries.length;i++){
            for(int j= queries[i][0];j<=queries[i][1];j+=queries[i][2]){
                long temp = (long)nums[j] * queries[i][3];
                nums[j] = (int) (temp % mod);
            }
        }
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}