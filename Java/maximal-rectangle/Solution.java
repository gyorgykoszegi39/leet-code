import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m + 1];
        int max = 0, area;
        
        height[m] = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0; j < m + 1; j++) {
                if (j < m)
                    if (matrix[i][j] == '1')
                        height[j] += 1;
                    else
                        height[j] = 0;

                if (s.isEmpty() || height[s.peek()] <= height[j])
                    s.push(j);
                else {
                    while (!s.isEmpty() && height[j] < height[s.peek()]) {
                        area = height[s.pop()] * (s.isEmpty() ? j : (j - s.peek() - 1));
                        max = Math.max(max, area);
                    }
                    s.push(j);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
    }
}
