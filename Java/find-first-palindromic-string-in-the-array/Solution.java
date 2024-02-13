public class Solution {
    public String firstPalindrome(String[] words) {
        for(String word : words)
            if(isPalindrome(word))
                return word;

        return "";
    }

    private boolean isPalindrome(String word) {
        int n = word.length() - 1;
        for(int i = 0; i <= n / 2; i++)
            if(word.charAt(i) != word.charAt(n - i))
                return false;
        
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.firstPalindrome(new String[] {"abc","car","ada","racecar","cool"}));
        System.out.println(s.firstPalindrome(new String[] {"abc", "ghi"}));
    }
}