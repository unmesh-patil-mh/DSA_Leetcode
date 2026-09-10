class Solution {
    public List<Integer> findDuplicates(int[] arr){
		int i = 0;
		
		// 1. Cyclic Sorting
		while(i < arr.length) {
			int correct = arr[i] - 1;
			
			if(arr[i] != arr[correct]) {
				swap(arr,i,correct);
			}else {
				i++;
			}
		}
		
		// 2. SEARCHING
		List<Integer> result = new ArrayList<>();
		for(int j = 0 ; j < arr.length ; j++) {
			if(arr[j] != j + 1) {
				result.add(arr[j]);
			}
		}
		
		return result;
	}
	
	public void swap(int[] arr , int a , int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}