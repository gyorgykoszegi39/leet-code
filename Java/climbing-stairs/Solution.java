public class Solution {
    
    public static int climbStairs(int n) {
        int count = 0;
        int prevCount = 1;
        int prevPrevCount = 0;

        while(n > 0) {
            count = prevCount + prevPrevCount;
            prevPrevCount = prevCount;
            prevCount = count;
            
            n--;
        }
    
        return count;    
    }

    public static void main(String[] args) {
        System.out.println(Solution.climbStairs(3));
        System.out.println(Solution.climbStairs(2));
        System.out.println(Solution.climbStairs(10));
    }
}
