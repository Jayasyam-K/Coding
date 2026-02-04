class Solution {

    public long maxSumTrionic(int[] nums) {
        int length = nums.length;
        long maxAnswer = Long.MIN_VALUE;

        for (int start = 0; start < length; start++) {
            int index = start;
            long totalSum = 0;

            // First step: Increasing
            index++;
            while (index < length && nums[index - 1] < nums[index]) {
                index++;
            }
            int peak = index - 1;

            if (peak == start) {
                continue;
            }

            // Second step: Decreasing
            totalSum += nums[peak] + nums[peak - 1];
            while (index < length && nums[index - 1] > nums[index]) {
                totalSum += nums[index];
                index++;
            }
            int lowPoint = index - 1;

            if (lowPoint == peak || lowPoint == length - 1 ||
                    (index < length && nums[index] <= nums[lowPoint])) {
                start = lowPoint;
                continue;
            }

            // Third step: Increasing
            totalSum += nums[lowPoint + 1];

            long maxRight = 0;
            long currentSum = 0;
            for (int k = lowPoint + 2; k < length && nums[k] > nums[k - 1]; k++) {
                currentSum += nums[k];
                maxRight = Math.max(maxRight, currentSum);
            }
            totalSum += maxRight;

            long maxLeft = 0;
            currentSum = 0;
            for (int k = peak - 2; k >= start; k--) {
                currentSum += nums[k];
                maxLeft = Math.max(maxLeft, currentSum);
            }
            totalSum += maxLeft;

            maxAnswer = Math.max(maxAnswer, totalSum);
            start = lowPoint - 1;
        }

        return maxAnswer;
    }
}
