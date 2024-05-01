public class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch) + 1;

        if(index == 0)
            return word;

        String reversedPrefix = new StringBuilder(word.substring(0, index)).reverse().toString();

        return reversedPrefix + word.substring(index);
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reversePrefix("abcdefd", 'd'));
        System.out.println(s.reversePrefix("xyxzxe", 'z'));
        System.out.println(s.reversePrefix("abcde", 'z'));

    }
}
