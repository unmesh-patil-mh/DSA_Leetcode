class Solution {
    public int smallestIndex(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++){  
            if(sum(arr[i]) == i){
                return i;
            }
        }

        return -1;
    }

    public int sum(int n){
        int sum = 0 ;

        while(n > 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}