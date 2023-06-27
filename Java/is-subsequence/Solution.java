
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();
        while(i < n && j < m) {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        return i == n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }
}
