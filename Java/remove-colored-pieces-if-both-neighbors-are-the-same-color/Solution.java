public class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0;
        char prevPrevChar = 'N', prevChar = 'N';
        for(char ch : colors.toCharArray()) {
            if(ch == prevChar && ch == prevPrevChar) {
                if(ch == 'A')
                    countA++;
                else
                countA--;
            } else {
                prevPrevChar = prevChar;
                prevChar = ch;
            }
        }
        return countA > 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.winnerOfGame("AAABABB"));
        System.out.println(s.winnerOfGame("AA"));
        System.out.println(s.winnerOfGame("ABBBBBBBAAA"));
    }
}
