import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.size() != 0) {
                if (c == stack.peek()) stack.pop();
                else stack.add(c);
            } else {
                stack.add(c);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }
}