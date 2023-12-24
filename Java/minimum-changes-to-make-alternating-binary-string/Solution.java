public class Solution {
    public int minOperations(String s) {
        return Math.min(count(s.toCharArray(), s.charAt(0)), count(s.toCharArray(), s.charAt(0) == '0' ? '1' : '0') + 1);
    }

    private int count(char[] chars, char start) {
        int count = 0;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == start) {
                count++;
                start = start == '0' ? '1' : '0';
            } else
                start = chars[i];
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minOperations("0100"));
        System.out.println(s.minOperations("10"));
        System.out.println(s.minOperations("1111"));
    }
}
