import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int result[] = new int[n];
        Arrays.sort(deck);

        Queue<Integer> indexQueue = new ArrayDeque<>();

        for(int i = 0; i < n; i++)
            indexQueue.add(i);

        for(int card : deck) {
            result[indexQueue.poll()] = card;
            if(!indexQueue.isEmpty())
                indexQueue.add(indexQueue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int card : s.deckRevealedIncreasing(new int[] {17, 13, 11, 2, 3, 5, 7}))
            System.out.print(card + " ");
    }
}
