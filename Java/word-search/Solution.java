public class Solution {
    public boolean exist(char[][] board, String word) {
        int[] freq = new int[256];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                freq[board[i][j]]++;
            }
        }

        for(char ch : word.toCharArray()) {
            if(freq[ch] == 0)
                return false;
            freq[ch]--;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(findWord(board, i, j, word.toCharArray(), 0))
                    return true;
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, int i, int j, char[] word, int k) {
      //  System.out.println(i + " " + j + " "  + " " + k + " " + word[k]);
        if(k == word.length)
            return true;

        if(i < 0 || i == board.length || j < 0 || j == board[0].length)
            return false;

        if(board[i][j] != word[k])
            return false;

        board[i][j] ^= 256;
        boolean result = findWord(board, i + 1, j, word, k + 1)
                        || findWord(board, i - 1, j, word, k + 1)
                        || findWord(board, i, j + 1, word, k + 1)
                        || findWord(board, i, j - 1, word, k + 1);
        board[i][j] ^= 256;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.exist(new char[][] {{'A', 'B'}}, "BA"));
        System.out.println(s.exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(s.exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(s.exist(new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}