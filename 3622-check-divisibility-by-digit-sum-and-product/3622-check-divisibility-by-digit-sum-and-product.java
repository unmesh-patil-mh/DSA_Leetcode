class Solution {
    public boolean checkDivisibility(int n) {
        if(n < 0){
            int num = -1 * n;
        }
        int num = n;

        int sum = 0 ;
        int product = 1;

        while(num > 0){
            int digit =  num % 10;
            sum += digit;
            product = product * digit;

            num = num / 10;
        }

        int total = sum + product;

        return n % total == 0;

    }
}