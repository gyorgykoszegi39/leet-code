import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<String> parantheses= new Stack<String>();

        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(' -> parantheses.push(")");
                case '[' -> parantheses.push("]");
                case '{' -> parantheses.push("}");
                default -> {
                    if(parantheses.isEmpty())
                        return false;
                    
                    char prevParantheses = parantheses.pop().charAt(0);
                    if(prevParantheses != s.charAt(i))
                        return false;
                }
            }
        }

        if(!parantheses.isEmpty())
            return false;
            
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
    }
}
