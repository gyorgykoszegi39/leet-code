
public class Solution {
    public boolean checkValidString(String s) {
        int left = 0, right = 0;

        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '*') {
               left++;
               right--;
            } else if(c == ')') {
                left--;
                right--;
            } else {
                left++;
                right++;
            }

            if(left < 0)
                return false;
            i++;

            right = Math.max(right, 0);
        }
        
        return right == 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        System.out.println(s.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));

    }
}
