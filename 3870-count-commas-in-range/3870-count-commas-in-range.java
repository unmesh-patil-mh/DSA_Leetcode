class Solution {
    public int countCommas(int n) {
        int num = n;
        int digits = 0;

        while(n > 0){
            n = n / 10;
            digits = digits + 1;
        }

        if(digits < 4){
            return 0;
        }

        int commas = 0;
        if(digits >= 4){
            for(int i = 1000 ; i <= num ; i++){
                commas += 1;
            }
        }

        return commas;
    }
}