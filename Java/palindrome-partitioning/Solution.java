import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        buildPalindromes(s, 0, new ArrayList<>(), result);

        return result;
    }

    void buildPalindromes(String s, int start, List<String> palindromes, List<List<String>> result) {
        if(start == s.length()) {
            result.add(new ArrayList<>(palindromes));
        }

        for(int i = start; i < s.length(); i++) {
            String partion = s.substring(start, i + 1);

            if(isPalindrome(partion.toCharArray())) {
                palindromes.add(partion);
                buildPalindromes(s, i + 1, palindromes, result);
                palindromes.remove(palindromes.size() - 1);
            }
        }

    }

    boolean isPalindrome(char[] chars) {
        int left = 0, right = chars.length - 1;

        while(left < right) {
            if(chars[left] != chars[right])
                return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<String>> result = s.partition("aab");

        for(List<String> palindromes : result) {
            for(String palindrome : palindromes)
                System.out.print(palindrome + " ");
            System.out.println();
        }
    }
}
