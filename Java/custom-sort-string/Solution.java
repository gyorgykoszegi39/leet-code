import java.util.Arrays;

public class Solution {

    public String customSortString(String order, String s) {
        int[] indexes = new int[26];

        for(char ch : order.toCharArray()) {
            indexes[ch - 'a'] = 1;
        }
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(indexes[ch - 'a'] == 0)
                str.append(ch);
            else {
                indexes[ch - 'a'] ++;
            }
        }

        StringBuilder sortedString = new StringBuilder();
        for(char ch : order.toCharArray()) {
            for(int i = 1; i < indexes[ch - 'a']; i++)
                sortedString.append(ch);
        }

        sortedString.append(str);

        return sortedString.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.customSortString("cba", "abcd"));
        System.out.println(s.customSortString("bcafg", "abcd"));
    }
}