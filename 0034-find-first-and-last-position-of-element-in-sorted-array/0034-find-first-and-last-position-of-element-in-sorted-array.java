class Solution {
    public int[] searchRange(int[] arr , int target) {
		int[] ans = {-1,-1};
		
		int a = SearchIndex(arr,target,true);
		int b = SearchIndex(arr,target,false);
		
		ans[0] = a;
		ans[1] = b;
		
		return ans;
	}
	
	public int SearchIndex(int[] arr , int target , boolean isStart) {
		int ans = -1;
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] < target) {
				start = mid + 1;
			}else if(arr[mid] > target) {
				end = mid - 1;
			}else {
				ans = mid;
				
				if(isStart) {
					end = mid - 1; // To find lowest index of element
				}else {
					start = mid + 1; // To find higest index of element 
				}
			}
		}
		
		return ans;
	}
	
}