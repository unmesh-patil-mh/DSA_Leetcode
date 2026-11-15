class Solution {
    public int numOfSubarrays(int[] arr) {
        final int mod = 1_000_000_007;
        int count = 0, prefixsum = 0;

        // counts 
        int odd = 0 , even = 1;
        for(int num : arr){
            prefixsum += num;
            // if prefixsum is even then add in count
            if(prefixsum % 2 == 0){
                count += odd;
                even++;
            }else{
                count += even;
                odd++; 
            }

            count %= mod;
        }

        return count;
    }
}