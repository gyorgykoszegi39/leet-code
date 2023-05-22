public class Solution {
    public static int minCostClimbingStairs(int[] cost) {
        int minSum = 0;
        int fPrevPrev = cost[0];
        int fPrev = cost[1];
        int n = cost.length;

        int i = 2;
        while(i < n) {
            minSum = cost[i] + Math.min(fPrev, fPrevPrev);
            fPrevPrev = fPrev;
            fPrev = minSum;
            i++;
        }
        return Math.min(fPrevPrev, fPrev);
    }

    public static void main(String[] args) {
        int[] test = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(Solution.minCostClimbingStairs(test));
    }
}

/* 
[1,100,1,1, 1,100, 1,1, 100,1]

f0 = 1
f1 = 1
f2 = 2
f3 = 2
f4 = 3
f5 = 3
f6 = 4
f7 = 4
f8 = 6
f9 = 6



f0 = 1 + (    100 / 1)
            1 / 1   1 / 1
1   -> 100  -> 1    -> 1
                    -> 1
            -> 1    -> 1
                    -> 100
    -> 1
            f1 = 100
*/