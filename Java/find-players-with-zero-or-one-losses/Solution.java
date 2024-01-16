import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] table = new int[100001];
        List<List<Integer>> winners = new ArrayList<>();
        List<Integer> secondPlace = new ArrayList<>();
        List<Integer> firstPlace = new ArrayList<>();

        for(int[] match : matches) {
            if(table[match[0]] == 0)
                table[match[0]] = -1;
            
            table[match[1]] = table[match[1]] == -1 ? 1 : table[match[1]] + 1;
        }

        for(int i = 0; i < 100001; i++) {
            if(table[i] == -1) {
                firstPlace.add(i);
            } else if(table[i] == 1) {
                secondPlace.add(i);
            }

        }

        winners.add(firstPlace);
        winners.add(secondPlace);

        return winners;
    }

    public List<List<Integer>> findWinners1(int[][] matches) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        List<List<Integer>> winners = new ArrayList<>();
        List<Integer> secondPlace = new ArrayList<>();
        List<Integer> firstPlace = new ArrayList<>();

        for(int[] match : matches) {
            table.putIfAbsent(match[0], 0);
            table.put(match[1], table.getOrDefault(match[1], 0) + 1);
        }

        for(Entry<Integer, Integer> entry : table.entrySet()) {
            if(entry.getValue() == 0) {
                firstPlace.add(entry.getKey());
            } else if(entry.getValue() == 1) {
                secondPlace.add(entry.getKey());
            }

        }
        firstPlace.sort(null);
        secondPlace.sort(null);

        winners.add(firstPlace);
        winners.add(secondPlace);

        return winners;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> winners = s.findWinners(new int[][] {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}});
        for(List<Integer> winner : winners) {
            for(Integer result : winner) {
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }
}
