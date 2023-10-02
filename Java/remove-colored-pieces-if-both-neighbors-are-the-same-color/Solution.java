public class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        char prevPrevChar = 'N', prevChar = 'N';
        for(char ch : colors.toCharArray()) {
            if(ch == prevChar && ch == prevPrevChar) {
                if(ch == 'A')
                    countA++;
                else
                    countB++;
            } else {
                prevPrevChar = prevChar;
                prevChar = ch;
            }
        }
        return countA > countB;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.winnerOfGame("AAABABB"));
        System.out.println(s.winnerOfGame("AA"));
        System.out.println(s.winnerOfGame("ABBBBBBBAAA"));
    }
}
