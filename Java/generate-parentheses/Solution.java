import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        createParenthesis(n, 0, "", result);

        return result;

    }

    private void createParenthesis(int n, int i, String parenthesis, List<String> createdParenthesis) {
        if(n == 0 && i == 0)
            createdParenthesis.add(parenthesis);
        else if(n == 0  && i != 0) {
            createParenthesis(n, i - 1, parenthesis + ")", createdParenthesis);
        } else {
            createParenthesis(n - 1, i + 1, parenthesis + "(", createdParenthesis);
            if(i > 0)
                createParenthesis(n, i - 1, parenthesis + ")", createdParenthesis);

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(String p : s.generateParenthesis(3)) {
            System.out.println(p);
        }
    }
}



