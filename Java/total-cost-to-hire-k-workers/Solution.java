import java.util.PriorityQueue;

public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long sum = 0;
        int n = costs.length;
        if(n == k) {
            for(Integer cost : costs) 
                sum += cost;

            return sum;
        }

        PriorityQueue<Integer> leftCost = new PriorityQueue<Integer>(candidates);
        PriorityQueue<Integer> rightCost = new PriorityQueue<Integer>(candidates);
        int leftIndex = candidates, rightIndex = n - candidates;

        rightIndex = rightIndex > leftIndex ? rightIndex : leftIndex;

        for(int i = 0; i < leftIndex; i++) {
            leftCost.add(costs[i]);
        }

        for(int i = rightIndex; i < n; i++) {
            rightCost.add(costs[i]);
        }

        if(rightIndex == n) {
           while(k > 0) {
                sum += leftCost.poll();
                k--;
            } 
        }

        while(k > 0) {
            k--;
            if(leftCost.peek() <= rightCost.peek()) {
                sum += leftCost.poll();

                if(leftIndex < rightIndex) {
                    leftCost.add(costs[leftIndex]);
                    leftIndex++;
                }
            } else {
                sum += rightCost.poll();

                if(leftIndex < rightIndex) {
                    rightIndex--;
                    rightCost.add(costs[rightIndex]);
                }
            }

            while(leftCost.isEmpty() && k > 0) {
                sum += rightCost.poll();
                k--;
            }

            while(rightCost.isEmpty() && k > 0) {
                sum += leftCost.poll();
                k--;
            }
        }


        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.totalCost(new int[] {17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println(s.totalCost(new int[] {1,2,4,1}, 3, 3));
        System.out.println(s.totalCost(new int[] {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58}, 11, 2));
        System.out.println(s.totalCost(new int[] {69,10,63,24,1,71,55,46,4,61,78,21,85,52,83,77,42,21,73,2,80,99,98,89,55,94,63,50,43,62,14}, 21, 31));
    }
}
