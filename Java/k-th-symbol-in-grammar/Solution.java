public class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1)
            return 0;
        
        if(k % 2 == 0)
            return kthGrammar( n - 1, k / 2) == 0 ? 1 : 0;
        else
            return kthGrammar(n - 1, (k + 1) / 2) == 0 ? 0 : 1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.kthGrammar(1, 1));
        System.out.println(s.kthGrammar(2, 1));
        System.out.println(s.kthGrammar(2, 2));
    }
}