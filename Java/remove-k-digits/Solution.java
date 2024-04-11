public class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() <= k)
            return "0";
        
        int i = -1, tmp = k;
        char[] digits = num.toCharArray();
        char[] result = new char[num.length()];

        for(char digit : digits) {
            while(tmp > 0 && i >= 0 && result[i] > digit) {
                tmp--;
                i--;
            }
            i++;
            result[i] = digit;
        }

        int leadingZero = 0;
        while(result[leadingZero] == '0' && leadingZero < num.length() - k - 1)
            leadingZero++;

        return String.valueOf(result, leadingZero, num.length() - k - leadingZero);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeKdigits("1432219", 3));
        System.out.println(s.removeKdigits("10200", 1));
        System.out.println(s.removeKdigits("10", 1));
    }
}
