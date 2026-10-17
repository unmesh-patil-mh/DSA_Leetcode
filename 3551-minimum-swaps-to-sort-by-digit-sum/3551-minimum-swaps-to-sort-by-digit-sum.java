import java.util.*;

class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = arr[i];
            nums[i][1] = i;
        }

        Arrays.sort(nums, (a, b) -> {
            int sumA = sum(a[0]);
            int sumB = sum(b[0]);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a[0], b[0]);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i][1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = nums[j][1];
                cycleSize++;
            }

            swaps += cycleSize - 1;
        }

        return swaps;
    }

    private int sum(int n) {
        int s = 0;

        while (n > 0) {
            s += n % 10;
            n /= 10;
        }

        return s;
    }
}