import java.util.Arrays;
public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqLetters = new int[25];
        int[] scoreWords = new int[words.length];
        int count, i = 0, maxScore = 0;
        for(char letter : letters)
            freqLetters[letter - 'a']++;
        
        for(String word : words) {
            count = 0;
            if(hasEnoughLetters(word, freqLetters)) {
                for(char ch : word.toCharArray())
                    count += score[ch - 'a'];
                increaseFreqLetters(word, freqLetters);
            }
            
            scoreWords[i++] = count;
            maxScore += count;
        }

        if(maxScore == 0)
            return 0;
        return getMaxScore(words, freqLetters, scoreWords, 0, 0);
    }

    int getMaxScore(String[] words, int[] freqLetters, int[] scoreWords, int start, int currentScore) {
        if(start == words.length) {
            return currentScore;
        }


        int score = 0;
        if(hasEnoughLetters(words[start], freqLetters) && scoreWords[start] != 0) {
            currentScore += scoreWords[start];
            score = getMaxScore(words, freqLetters, scoreWords, start + 1, currentScore);
            currentScore -= scoreWords[start];
            increaseFreqLetters(words[start], freqLetters);
        }
        
        score = Math.max(score, getMaxScore(words, freqLetters, scoreWords, start + 1, currentScore));

        return score;
    }

    boolean hasEnoughLetters(String word, int[] freqLetters) {
        char[] letters = word.toCharArray();
        int i = 0;
        while(i < letters.length) {
            if(freqLetters[letters[i] - 'a'] == 0) {
                for(int j = 0; j < i; j++)
                    freqLetters[letters[j] - 'a']++;
                return false;
            }

            freqLetters[letters[i] - 'a']--;
            i++;
        }
        return true;
    }
    void increaseFreqLetters(String word, int[] freqLetters) {
        for(char ch : word.toCharArray())
            freqLetters[ch - 'a'] += 1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxScoreWords(new String[] {"leetcode"}, new char[] {'l', 'e', 't', 'c', 'o', 'd'}, new int[] {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
        System.out.println(s.maxScoreWords(new String[] {"dog", "cat", "dad", "good"}, new char[] {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[] {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    }
}
