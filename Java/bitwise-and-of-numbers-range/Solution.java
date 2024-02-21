public class Solution {
    
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left)
            right &= (right - 1);

        return right;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.rangeBitwiseAnd(5, 7));
        System.out.println(s.rangeBitwiseAnd(0, 0));
        System.out.println(s.rangeBitwiseAnd(1, 2147483647));
    }
}