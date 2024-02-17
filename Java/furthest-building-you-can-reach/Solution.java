import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> sortedDiff = new PriorityQueue<>(Comparator.reverseOrder());
        int diffToClimbe;
        for(int i = 1; i < heights.length; i++) {
            if(heights[i - 1] >= heights[i])
                continue;
            
            diffToClimbe = heights[i] - heights[i - 1];
            if(bricks >= diffToClimbe) {
                bricks -= diffToClimbe;
                sortedDiff.add(diffToClimbe);
            } else {
                if(ladders == 0)
                    return i - 1;

                if(!sortedDiff.isEmpty() && sortedDiff.peek() > diffToClimbe) {
                    bricks += (sortedDiff.poll() - diffToClimbe);
                    sortedDiff.offer(diffToClimbe);
                }

                ladders--;
            }
        }

        return heights.length - 1;
    }


    public int furthestBuilding1(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> sortedDiff = new PriorityQueue<>();
        int diffToClimbe;
        for(int i = 1; i < heights.length; i++) {
            if(heights[i - 1] >= heights[i])
                continue;

            diffToClimbe = heights[i] - heights[i - 1];
            if(sortedDiff.size() < ladders) {
                sortedDiff.add(diffToClimbe);
                continue;
            }

            if(ladders != 0) {
                sortedDiff.add(diffToClimbe);
                diffToClimbe = sortedDiff.poll();
            }       

            if(bricks < diffToClimbe)
                return i - 1;

            bricks -= diffToClimbe;
        }

        return heights.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.furthestBuilding(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(s.furthestBuilding(new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(s.furthestBuilding(new int[] {14, 3, 19, 3}, 17, 0));
        System.out.println(s.furthestBuilding1(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(s.furthestBuilding1(new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(s.furthestBuilding1(new int[] {14, 3, 19, 3}, 17, 0));
    }    
}
