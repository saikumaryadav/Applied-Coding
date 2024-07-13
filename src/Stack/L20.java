package Stack;

import java.util.Stack;
/**
 * https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 * Input: s = "()"
 * Output: true
 *
 * */
public class L20 {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }
    public static  boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i< s.length() ; i++){
            char ch = s.charAt(i);
            if( (ch == '(') || (ch == '{')||( ch=='[')){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    char topElement = stack.peek();
                    if( (ch == ')' && topElement == '(') || (ch == '}' && topElement == '{')
                            || (ch == ']' && topElement == '[')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }

        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
