import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.empty()) {
                if (c == ')' && stack.peek() == '(') stack.pop();
                else stack.add(c);
            }
            else stack.add(c);
        }
        
        return stack.empty();
    }
}