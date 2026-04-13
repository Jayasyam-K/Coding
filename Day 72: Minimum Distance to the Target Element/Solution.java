class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int absValue = Integer.MAX_VALUE;
        for(int i = 0;i<=nums.length - 1 ;++i){
            if(nums[i] == target){
                absValue = Math.min(absValue,Math.abs(i - start));
            }
        }
        return absValue;
    }
}