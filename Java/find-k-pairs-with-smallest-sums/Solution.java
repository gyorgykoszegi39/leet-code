import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ComparePair implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return (o1[0] + o1[1]) - (o2[0] + o2[1]);
    }

}
public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;

        PriorityQueue<int[]> queuePairs = new PriorityQueue<>(k, new ComparePair());

        for(int i = 0; i < n && i <= k; i++) {
            queuePairs.offer(new int[] {nums1[i], nums2[0], 0});
        }

        List<List<Integer>> listPairs = new ArrayList<List<Integer>>();
        for(int i = 1; i <= k && !queuePairs.isEmpty() ; i++) {
            int[] pair = queuePairs.poll();
            int j = pair[2] + 1;

            listPairs.add(Arrays.asList(pair[0], pair[1]));

            if(j < m)
                queuePairs.offer(new int[] {pair[0], nums2[j], j});

        }

        return listPairs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        for(List<Integer> list : s.kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 11)) {
            for(Integer num : list) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
