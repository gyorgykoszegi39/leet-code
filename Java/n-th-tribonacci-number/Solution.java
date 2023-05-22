public class Solution {
    public static int tribonacci(int n) {
        if(n <= 1)
            return n;
        if(n == 2)
            return 1;
        
        int fPrevPrev = 0, fPrev = 1, f = 1;

        n -= 2;

        while(n > 0) {
            int tmp = f;
            f = f + fPrev + fPrevPrev;
            fPrevPrev = fPrev;
            fPrev = tmp;
            n--;
        }

        return f;
    }

    public static void main(String[] args) {
        System.out.println(Solution.tribonacci(25));
    }
}
