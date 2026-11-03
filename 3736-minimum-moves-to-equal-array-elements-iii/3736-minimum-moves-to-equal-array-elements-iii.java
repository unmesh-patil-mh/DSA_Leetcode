class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n : nums){
            max = Math.max(max,n);
        }

        int res = 0;
        for(int x : nums){
            res += (max - x);
        }

        return res;
    }
}