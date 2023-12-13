public class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;

        for(int i = 0; i < mat.length; i++) {
            if(isColSpecial(mat, i, getSpecialColPos(mat, i)))
                count++;
        }

        return count;
    }

    private int getSpecialColPos(int[][] mat, int row) {
        int pos = -1;

        for(int j = 0; j < mat[0].length; j++) {
            if(mat[row][j] == 1) {
                if(pos >= 0)
                    return -1;
                
                pos = j;
            }
        }

        return pos;
    }

    private boolean isColSpecial(int[][] mat, int row, int col) {
        if(col == -1)
            return false;

        for(int i = 0; i < mat.length; i++)
            if(mat[i][col] == 1 && row != i)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numSpecial(new int[][] {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
        System.out.println(s.numSpecial(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
}
