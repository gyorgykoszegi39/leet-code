import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.parallelSort(strs);
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0, n = first.length();
        while(i < first.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(s.longestCommonPrefix(new String[]{"aflower","bflow","flight"}));
    }
}
