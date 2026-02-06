class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        // sorting the array
        Arrays.sort(nums);

        int result = n;
        int right = 0;

        for (int left = 0; left < n; left++) {
            long limit = (long) nums[left] * k;
            while (right < n && nums[right] <= limit) {
                right++;
            }
            result = Math.min(result, n - (right - left));
        }
        return result;
    }
}