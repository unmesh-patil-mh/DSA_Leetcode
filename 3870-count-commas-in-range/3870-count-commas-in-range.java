class Solution {
    public int countCommas(int n) {
        int num = n;
        int digits = 0;

        while(n > 0){
            n = n/10;
            digits += 1;
        }

        if(digits < 4){
            return 0;
        }
 
        int count = 0;
        if(digits >= 4){
            for(int i = 1000 ; i <= num ; i++){
                count++;
            }
        }

        return count;
    }
}