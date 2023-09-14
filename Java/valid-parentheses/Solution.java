import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> parantheses= new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case '(' -> parantheses.push(')');
                case '[' -> parantheses.push(']');
                case '{' -> parantheses.push('}');
                default -> {
                    if(parantheses.isEmpty())
                        return false;

                    if(parantheses.pop() != ch)
                        return false;
                }
            }
        }
        return parantheses.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
    }
}
