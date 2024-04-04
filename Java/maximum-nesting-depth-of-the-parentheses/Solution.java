public class Solution {

    public int maxDepth(String s) {
        int depth = 0, maxDepth = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if(ch == ')')
                depth--;
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(s.maxDepth("(1)+((2))+(((3)))"));
    }
}
