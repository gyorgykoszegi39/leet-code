public class Solution {
    public boolean halvesAreAlike(String s) {
        char[] chars = s.toCharArray();
        int j = s.length() / 2;
        int count = 0;
        for(int i = 0; i < j; i++) {
            if("aeiouAEIOU".indexOf(chars[i]) >= 0)
                count++;
            
            if("aeiouAEIOU".indexOf(chars[j + i]) >= 0)
                count--;
        }
        return  count == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.halvesAreAlike("book"));
        System.out.println(s.halvesAreAlike("textbook"));
    }
}
