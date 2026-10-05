class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(0);
            } 
            else {
                int inside = stack.pop();

                int score = (inside == 0) ? 1 : 2 * inside;

                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
    }
}