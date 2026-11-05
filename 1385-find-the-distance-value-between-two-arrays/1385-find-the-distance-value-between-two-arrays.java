class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c = 0;
        for(int n : arr1){
            if(isValid(n , arr2 , d)){
                c++;
            }
        }
        return c;
    }

    public boolean isValid(int n , int[] arr2 , int d){
        for(int e : arr2){
            if(Math.abs(e - n) <= d){
                return false;
            }
        }
        return true;
    }
}