class Solution {
    public int splitArray(int[] arr , int m) { // Int m is no of splits allowed
		int start = 0;
		int end = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			start = Math.max(start , arr[i]); // to find max element in our Array
			end += arr[i]; // To Find Sum of all elements in our array
		} 
		
		// IMPLEMENTING BINARY SEARCH
		while(start <= end) {
			int mid = start + (end - start)/2;
			// Whether split is smaller than our mid we are finding it 
			
			int sum = 0;
			int split = 1;
			
			for(int num : arr) {
				if(sum + num > mid) {
					sum = num;
					split++;
				}
				else {
					sum += num;
				}
			}
			
			// checking whether the number of splits we have done are valid or not 
			if(split > m) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		return start; // WE ARE RETURNING VALUE WHICH SATISFIES OUR SPLIT WITH MINIMUM VALUE
	}
}