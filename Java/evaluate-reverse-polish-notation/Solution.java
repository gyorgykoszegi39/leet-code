import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        int a, b;

        for(String token : tokens) {
            switch (token) {
                case "+":
                    a = deque.pop();
                    b = deque.pop();

                    deque.push(b + a);
                    break;
                case "-":
                    a = deque.pop();
                    b = deque.pop();

                    deque.push(b - a);
                    break;
                case "/":
                    a = deque.pop();
                    b = deque.pop();

                    deque.push(b / a);
                    break;
                case "*":
                    a = deque.pop();
                    b = deque.pop();

                    deque.push(b * a);
                    break;
                default:
                    deque.push(Integer.valueOf(token));
                    break;
            }
        }

        return deque.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(s.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(s.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
