import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length - 1;

        for(int i = g.length - 1; i >= 0 && j >= 0; i--) {
            if(g[i] <= s[j]) {
                j--;
            }
        }

        return s.length - j - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
        System.out.println(s.findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3}));
    }
}
