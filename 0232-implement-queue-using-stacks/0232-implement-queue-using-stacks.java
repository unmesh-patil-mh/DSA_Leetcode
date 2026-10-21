class MyQueue {

	private Stack<Integer> first;
	private Stack<Integer> Second;
	
    public MyQueue() {
        first = new Stack<>();
        Second = new Stack<>();
    }
    
    // Pop EFFECTIVE Solution
    public void push(int x) {
        while(!first.isEmpty()) {
        	Second.push(first.pop());
        }
        
        // adding on top of Second
        Second.push(x);
        
        while(!Second.isEmpty()){
        	first.push(Second.pop());
        }
    }
    
    public int pop() {
        return first.pop();
    }
    
    public int peek() {
    	return first.peek();
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