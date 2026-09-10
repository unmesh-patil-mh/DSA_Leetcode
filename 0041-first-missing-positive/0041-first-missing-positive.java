class Solution {
    static int firstMissingPositive(int[] arr) {
		// 1. CYCLIC SORTING
		int i = 0;
		while(i < arr.length) {
			
			if(arr[i] > 0 && arr[i] < arr.length) {
				int correct = arr[i] - 1;
				
				if(arr[i] != arr[correct]) {
					swap(arr,i,correct);					
				}else {
					i++;
				}
			}else {
				i++;
			}
		}
		
		
		// 2. SEARCHING FOR FIRST MISSING POSITIVE
		for(int j = 0 ; j < arr.length ; j++) {
			if(arr[j] != j+1) {
				return j + 1;
			}
		}
		
		return arr.length + 1;
	}
	
	static void swap(int[] arr, int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
}