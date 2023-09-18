import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
class Soldier {
    int index;
    int count;

    Soldier(int i, int c) {
        index = i;
        count = c;
    }
}
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> soldiers = new PriorityQueue<>((s1, s2) -> s2[1] == s1[1] ? s2[0] - s1[0] :  s2[1] - s1[1]);

        for(int i = 0; i < mat.length; i++) {
            soldiers.add(new int[]{i, findLastOne(mat[i])});
            if(soldiers.size() > k)
                soldiers.poll();
        }

        int result[] = new int[k];
        while(k > 0) {
            k--;
            result[k] = soldiers.poll()[0];
        }

        return result;
    }

    public int findLastOne(int row[]) {
        int left = 0, right = row.length - 1, mid;

        while(left <= right) {
            mid = right - left;
            if(row[mid] == 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int i : s.kWeakestRows(new int[][] {{ 1,1,0,0,0},
                                                {1,1,1,1,0},
                                                {1,0,0,0,0},
                                                {1,1,0,0,0},
                                                {1,1,1,1,1}},
                                    3)) {
            System.out.println(i);
        }
    }
}
