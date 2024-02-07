import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String frequencySort(String s) {
        int[] charsFreq = new int[128];
        for(char ch : s.toCharArray())
            charsFreq[ch]++;

        ArrayList<Character> sortedCharacters = new ArrayList<>();
        for(int i = 0; i < 128; i++) {
            if(charsFreq[i] != 0)
                sortedCharacters.add((char)i);
        }

        sortedCharacters.sort(Collections.reverseOrder((ch1, ch2) -> Integer.compare(charsFreq[ch1], charsFreq[ch2])));

        StringBuilder sortedString = new StringBuilder();
        for(Character ch : sortedCharacters)
            sortedString.append(String.valueOf(ch).repeat(charsFreq[ch]));

        return sortedString.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.frequencySort("tree111"));
        System.out.println(s.frequencySort("cccaaa"));
        System.out.println(s.frequencySort("Aabb"));
    }
}
