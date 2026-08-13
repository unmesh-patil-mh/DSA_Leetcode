class Solution {
    public void rotate(int[][] nums) {
		int n = nums.length;
		
		// TRAVERSE
		for(int i = 0 ; i < n ; i++) {
			for(int j = i ; j < n ; j++) {
				int temp = nums[i][j];
				nums[i][j] = nums[j][i];
				nums[j][i] = temp; 
			}
		}
		
		// Reverse With Each Row
		for(int i = 0 ; i < n ; i++) {
			int left = 0;
			int right = n - 1;
			
			while(left < right) {
				int temp = nums[i][left];
				nums[i][left] = nums[i][right];
				nums[i][right] = temp;
				
				left++;
				right--;
			}
		}
	
    }
}