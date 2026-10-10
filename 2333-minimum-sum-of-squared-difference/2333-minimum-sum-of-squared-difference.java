
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2,
                                 int k1, int k2) {

        long k = (long) k1 + k2;
        int n = nums1.length;
        int[] diff = new int[n];

        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long total = 0;
        for (int d : diff) {
            total += d;
        }

        // Enough operations to make every difference zero
        if (k >= total) {
            return 0L;
        }

        int left = 0;
        int right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int target = left;
        long remaining = k;
        long answer = 0;

        for (int d : diff) {
            if (d > target) {
                remaining -= d - target;
                d = target;
            }
            answer += (long) d * d;
        }

        // Use leftover operations to reduce target-level differences.
        // Each reduction from target to target-1 saves 2*target - 1.
        if (target > 0) {
            long countAtTarget = 0;

            for (int d : diff) {
                if (d >= target) {
                    countAtTarget++;
                }
            }

            // Binary search ensures the number of operations to reach
            // target is <= k. Any leftover operations reduce target values.
            long reductions = k;
            for (int d : diff) {
                if (d > target) {
                    reductions -= d - target;
                }
            }

            answer -= reductions * (2L * target - 1);
        }

        return answer;
    }
}
