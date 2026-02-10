package app.idea;

import java.util.Stack;

public class Q20ValidParentheses {

  // Sliding Window
  public boolean isValid(String s) {
    if (s.length()%2 == 1) return false;

    Stack<Character> stack = new Stack<>();

    for (int i = 0;i<s.length();i++) {
      if (s.charAt(i) == '(') {
        stack.push(')');
      } else if (s.charAt(i) == '{') {
        stack.push('}');
      } else if (s.charAt(i) == '[') {
        stack.push(']');
      } else {
        if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}