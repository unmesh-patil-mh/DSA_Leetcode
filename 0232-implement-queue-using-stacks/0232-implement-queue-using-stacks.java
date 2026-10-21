class MyQueue {

	// Push EFFECTIVE Solution
	
	private Stack<Integer> first;
	private Stack<Integer> Second;
	
    public MyQueue() {
        first = new Stack<>();
        Second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        if(first.isEmpty()) {
        	return -1;
        }
        
        // Copying first Element Array into Second as in reverse order
        while(!first.isEmpty()) {
        	Second.push(first.pop());
        }
        
        int removed =  Second.pop();
        
        // Returning All Elements back to first
        while(!Second.isEmpty()) {
        	first.push(Second.pop());
        }
        
        return removed;
    }
    
    public int peek() {
    	while(!first.isEmpty()) {
    		Second.push(first.pop());
    	}
    	
    	int peeked = Second.peek();
    	
    	while(!Second.isEmpty()) {
    		first.push(Second.pop());
    	}
    	
    	return peeked;
    }
    
    public boolean empty() {
        if(first.isEmpty()) {
        	return true;
        }
        
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */