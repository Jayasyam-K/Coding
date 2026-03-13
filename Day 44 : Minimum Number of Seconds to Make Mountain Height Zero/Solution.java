class Solution {
    private boolean canReduce(long mid, int mountainHeight, int[] workerTimes) {
        long total = 0;
        for (int t : workerTimes) {
            long height = (long) (Math.sqrt((2.0 * mid) / t + 0.25) - 0.5);
            total += height;
            if (total >= mountainHeight)
                return true;
        }
        return false;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int max = 0;

        for (int t : workerTimes) {
            max = Math.max(max, t);
        }
        long left = 1;
        long right = (long) max * mountainHeight * (mountainHeight + 1) / 2;
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}