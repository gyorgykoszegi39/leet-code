
public class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        while(i >= 0 && num.charAt(i) % 2 == 0)
            i--;

        return i < 0 ? "" : num.substring(0, i + 1); 
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestOddNumber("52"));
        System.out.println(s.largestOddNumber("4206"));
        System.out.println(s.largestOddNumber("35427"));
    }
}
