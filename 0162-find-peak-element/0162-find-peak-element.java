class Solution {
    static int findPeakElement(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) { // it will break when start == end so we return start or end
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] < arr[mid+1]) { // Increasing Order
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return start; // as start = end we can return end; also
	}
}