package easy;

import java.util.Stack;

/**
 * @author t0k02w6 on 08/02/22
 * @project ds-algo-2021
 */
public class ValidParenthesisLeetcode20 {
    private static boolean isProperCombination(char topChar, char currentChar) {
        return (currentChar == ')' && topChar == '(')
                || (currentChar == '}' && topChar == '{')
                || (currentChar == ']' && topChar == '[');
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(!isProperCombination(topChar, s.charAt(i)))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
