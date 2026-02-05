class Solution {
    public int[] constructTransformedArray(int[] nums) {
        //Storing array's length
        int n = nums.length;

        int[] result = new int[n];
        //The newIdx mathematical formula handles negative wrapping , the extra +n and %n are added in case of large n , to get a positive number
        for(int i=0;i<n;i++){
            int newIdx = (((i+nums[i])%n + n) % n);
            result[i] = nums[newIdx];
        }
        return result;
    }
}