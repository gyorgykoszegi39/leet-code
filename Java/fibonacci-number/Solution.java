
public class Solution {
    public static int fib(int n) {
        if(n <= 1)
            return n;
        
        int fPrev = 0, f = 1;

        n--;
        while(n > 0) {
            n--;
            int tmp = f;
            f += fPrev;
            fPrev = tmp;
        }

        return f;
    }

    public static void main(String[] args) {
        System.out.println(Solution.fib(2));
        System.out.println(Solution.fib(3));
        System.out.println(Solution.fib(4));
    }
}
