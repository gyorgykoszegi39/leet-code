public class Solution {
    
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int num = 0, originalNum = x;
        while(x > 0) {
            num = num * 10 + x % 10;
            x /= 10;
        }

        return originalNum == num;    
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
        System.out.println(s.isPalindrome(10));
    }
}
