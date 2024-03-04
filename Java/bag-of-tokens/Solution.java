import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1, score = 0, maxScore = 0;

        while(left <= right) {
            if(score == 0 && tokens[left] > power)
                return maxScore;
            if(tokens[left] <= power) {
                score++;
                maxScore = Math.max(score, maxScore);
                power -= tokens[left];
                left++;
            } else {
                score--;
                power += tokens[right];
                right--;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.bagOfTokensScore(new int[] {10}, 5));
        System.out.println(s.bagOfTokensScore(new int[] {20, 10}, 15));
        System.out.println(s.bagOfTokensScore(new int[] {1, 2, 3, 4}, 2));        
        System.out.println(s.bagOfTokensScore(new int[] {3, 4}, 2));
    }
}
