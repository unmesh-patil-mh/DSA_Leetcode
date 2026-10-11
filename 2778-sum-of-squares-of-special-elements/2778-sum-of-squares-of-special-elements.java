class Solution {
    public int sumOfSquares(int[] arr) {
        int sum = 0;

        int n = arr.length;



        for(int i = 0 ; i < n ; i++){
            if(n % (i + 1) == 0){
                sum += arr[i] * arr[i];
            }
        }

        return sum;
    }
}