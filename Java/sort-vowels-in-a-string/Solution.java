import java.util.Arrays;

public class Solution {
    public String sortVowels(String s) {
        StringBuilder result = new StringBuilder(), vowels = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if("AEIUOaeiou".indexOf(ch) > -1) {
                vowels.append(ch);
                result.append("_");
            } else {
                result.append(ch);
            }
        }
        char[] sortedVowels = vowels.toString().toCharArray();
        Arrays.sort(sortedVowels);

        int j = 0;
        for(int i = 0; i < sortedVowels.length; i++) {
            while(result.charAt(j) != '_')
                j++;
            result.setCharAt(j, sortedVowels[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sortVowels("lEetcOde"));
    }
}
