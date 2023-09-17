
public class Solution {
    public int[] plusOne(int[] digits) {
        
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }

        if(i < 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        else
            digits[i]++;

        return digits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(int digit : s.plusOne(new int[] {9}))
            System.out.println(digit);
    }
}
