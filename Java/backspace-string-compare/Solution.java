public class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        return getReversBackspacedWord(s).equals(getReversBackspacedWord(t));
    }

    private String getReversBackspacedWord(String s) {
        StringBuilder str = new StringBuilder();
        int count = 0;

        for(int i = s.length() - 1; i >= 0; i--)
            if(s.charAt(i) == '#')
                count++;
            else {
                if(count == 0)
                    str.append(s.charAt(i));
                count = Math.max(0, count - 1);
            }
        
        return str.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
}
