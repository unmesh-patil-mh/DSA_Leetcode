class Solution {
    public int minAddToMakeValid(String s) {

        Stack<Character> ans = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                ans.push('(');
            }
            else {
                if (!ans.isEmpty()) {
                    ans.pop();
                }
                else {
                    count++;
                }
            }
        }

        return count + ans.size();
    }
}