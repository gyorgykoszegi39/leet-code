
public class Solution {

    public int lengthOfLastWord(String s) {

        int i = s.length() - 1, count;
        while(s.charAt(i) == ' ') {
            i--;
        }

        count = i;

        while(i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        
        return count - i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("a"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
    }
    
}
