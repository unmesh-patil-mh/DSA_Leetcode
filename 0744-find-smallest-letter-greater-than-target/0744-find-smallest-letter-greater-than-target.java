class Solution {
    public char nextGreatestLetter(char[] arr , char target) {
		
		int start = 0;
		
		int n = arr.length;
		
		int end = n -1;
		
		int ans = 0;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;

			if(arr[mid] <= target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
			return arr[start % n];
	}
}