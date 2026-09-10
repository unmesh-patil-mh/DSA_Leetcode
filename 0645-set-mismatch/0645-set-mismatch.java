class Solution {
    public int[] findErrorNums(int[] arr) {
		// 1. Cyclic SORTING
		int i = 0;
		while(i < arr.length) {
			int correct = arr[i] - 1;
			if(arr[i] != arr[correct]) {
				swap(arr,i,correct);
			}else {
				i++;
			}
		}
		
		// 2. SEARCHING
		for(int j = 0 ; j < arr.length ; j++) {
			if(arr[j] != j + 1) {
				return new int[] {arr[j] , j + 1};
			}
		}
		
		return new int[] {};
	}
	
	public void swap(int[] arr, int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}