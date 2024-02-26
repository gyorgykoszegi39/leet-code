import java.util.Optional;

public class Solution {
    public int myAtoi(String s) {
        long num = 0;
        Optional<Boolean> isNegativ = Optional.empty();
        boolean hasNum = false;

        for(char ch : s.toCharArray()) {
            if(ch == ' ' && !hasNum && !isNegativ.isPresent())
                continue;

            if(ch == '-') {
                if(isNegativ.isPresent() || hasNum)
                    break;
                isNegativ = Optional.of(true);
                continue;
            }

            if(ch == '+') {
                if(isNegativ.isPresent() || hasNum)
                    break;
                isNegativ = Optional.of(false);
                continue;
            }
            
            if(ch < '0' || ch > '9' || num > Integer.MAX_VALUE)
                break;

            hasNum = true;
            num *= 10;
            num += ch - '0';
        }
        
        num = isNegativ.orElseGet(() -> false) ? -1 * num : num;
        if(num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("   -42"));
        System.out.println(s.myAtoi("4193 with words"));
    }
}