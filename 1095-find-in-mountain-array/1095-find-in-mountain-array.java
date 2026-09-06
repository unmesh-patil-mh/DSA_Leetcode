class Solution {

    public int Peak(MountainArray arr) {

        int start = 0;
        int end = arr.length() - 1;

        while(start < end) {

            int mid = start + (end - start) / 2;

            int midValue = arr.get(mid);
            int nextValue = arr.get(mid + 1);

            if(midValue < nextValue) {
                // Increasing
                start = mid + 1;
            } 
            else {
                // Decreasing
                end = mid;
            }
        }

        return start;
    }


    public int OrdinalSearch(
        MountainArray arr,
        int target,
        int start,
        int end,
        boolean isAsc) {

        while(start <= end) {

            int mid = start + (end - start) / 2;

            // Only ONE get() call
            int value = arr.get(mid);

            if(value == target) {
                return mid;
            }

            if(value < target) {

                if(isAsc) {
                    start = mid + 1;
                } 
                else {
                    end = mid - 1;
                }

            } 
            else {

                if(isAsc) {
                    end = mid - 1;
                } 
                else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }


    public int findInMountainArray(int target, MountainArray mountainArr) {

        // Step 1: Find peak
        int peak = Peak(mountainArr);

        // Step 2: Search ascending part
        int result = OrdinalSearch(
            mountainArr,
            target,
            0,
            peak,
            true
        );

        if(result != -1) {
            return result;
        }

        // Step 3: Search descending part
        return OrdinalSearch(
            mountainArr,
            target,
            peak + 1,
            mountainArr.length() - 1,
            false
        );
    }
}