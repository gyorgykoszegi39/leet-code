import java.util.Arrays;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        for(int i = 0; i < dist.length; i++) {
            dist[i] = (dist[i] - 1) / speed[i];
        }
        Arrays.sort(dist);
        for(int i = 0; i < dist.length; i++) {
            if(dist[i] < i)
                return i;
        }

        return dist.length;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.eliminateMaximum(new int[] {1, 3, 4}, new int[] {1, 1, 1}));
        System.out.println(s.eliminateMaximum(new int[] {1, 1, 2, 3}, new int[] {1, 1, 1, 1}));
        System.out.println(s.eliminateMaximum(new int[] {3, 2, 4}, new int[] {5, 3, 2}));
    }
}
