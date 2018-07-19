package com.jda.data_structure_programs;

import com.jda.utility.Stack;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class BalancedParentheses {

  public static
  void main(String[] args) {
    System.out.println("Enter an arithmetic expression");
    Reader reader = new Utility().new Reader();
    String expression = reader.readLine();

    System.out.println(isBalanced(expression));
  }

  private static
  boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();
    for (char ch : expression.toCharArray()) {
      switch (ch) {
        case '(':
          stack.push('(');
          break;
        case ')':
          if (stack.isEmpty()) { return false; }
          stack.pop();
          break;
        default:
      }
    }
    return stack.isEmpty();
  }
}
