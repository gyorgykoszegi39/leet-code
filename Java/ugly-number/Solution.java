public class Solution {

    public static boolean isUgly(int n) {
        
        if(n < 1)
            return false;
            
        while(n % 2 == 0)
            n /= 2;
        
        while(n % 3 == 0)
            n /= 3;
        
        while(n % 5 == 0)
            n /= 5;

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isUgly(6));
        System.out.println(Solution.isUgly(14));
    }
}
