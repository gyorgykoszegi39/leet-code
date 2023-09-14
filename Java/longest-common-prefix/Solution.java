import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.parallelSort(strs);
        int i = 0, n = strs.length;
        while(i < strs[0].length() && strs[0].charAt(i) == strs[n - 1].charAt(i)) {
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
