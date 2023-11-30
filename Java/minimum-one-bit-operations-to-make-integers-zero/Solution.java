
public class Solution {
    public int minimumOneBitOperations(int n) {
        if(n <= 1)
            return n;
        
        return n^minimumOneBitOperations(n/2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minimumOneBitOperations(3));
        System.out.println(s.minimumOneBitOperations(6));
    }
}
