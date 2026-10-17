class Solution {
	// WE WILL USE FAST AND SLOW POINTER
	
	// 1. Square Sum Function
	public int squaresum(int n) {
		int ans = 0;
		
		while(n > 0) {
			int rem = n % 10;
			ans += rem * rem;
			n /= 10;
		}
		
		return ans;
	}
	
	// 2. Happy Number :-
	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		
		do {
			slow = squaresum(slow); // first square
			fast = squaresum(squaresum(fast)); // skip middle square and move forward			
		}while(slow != fast);
		
		if(slow == 1) {
			return true;
		}
		
		return false;
	}
}