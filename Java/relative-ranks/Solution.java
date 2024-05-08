import java.util.PriorityQueue;

public class Solution {

    public String[] findRelativeRanks(int[] score) {
        int i, n = score.length, rank;
        PriorityQueue<Integer> ranking = new PriorityQueue<>((a, b)->score[b]-score[a]);

        for(i = 0; i < n; i++)
            ranking.add(i);

        String[] result = new String[n];
        rank = 1;
        while(!ranking.isEmpty()) {
            i = ranking.poll();
            if(rank > 3)
                result[i] = String.valueOf(rank);
            else if(rank == 1)
                result[i] = "Gold Medal";
            else if(rank == 2)
                result[i] = "Silver Medal";
            else
                result[i] = "Bronze Medal";
            rank++;
        }

        return result;
    }

    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        int[] ranking = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++)
                if(score[i] > score[j])
                    ranking[j]++;
                else
                    ranking[i]++;
        }

        String[] result = new String[n];

        for(int i = 0; i < n; i++) {
            if(ranking[i] > 2)
                result[i] = String.valueOf(ranking[i] + 1);
            else if(ranking[i] == 0)
                result[i] = "Gold Medal";
            else if(ranking[i] == 1)
                result[i] = "Silver Medal";
            else
                result[i] = "Bronze Medal";
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for (String rank : s.findRelativeRanks(new int[] {5, 4, 3, 2, 1}))
            System.out.print(rank + " ");
    }
}
