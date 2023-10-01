public class Solution {

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        for(String word: s.split(" ")) {
            result.append(new StringBuilder(word).reverse());
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }
    public static void main(String[] args) {    
        Solution s = new Solution();
        System.out.println(s.reverseWords("Let's take LeetCode contest"));
    }    
}
