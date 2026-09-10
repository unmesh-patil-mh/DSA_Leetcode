class Solution {
    static int missingNumber(int[] arr) {
	
		int i = 0;
		
		// 1. Sorting
		while(i < arr.length) {
			int correct = arr[i]; // range is 0 to n
			
			if(arr[i] < arr.length && arr[i] != arr[correct]) {
				swap(arr , i , correct);
			}else {
				i++;
			}
		}
		
		// 2. Searching
		for(int j = 0 ; j < arr.length ; j++) {
			if(arr[j] != j) {
				return j;
			}
		}
		
		return arr.length;
		
	}
	
	static void swap(int[] arr , int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}