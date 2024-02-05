import java.util.Arrays;

public class Solution {

    public int firstUniqChar(String s) {
        int min = s.length(), firstIndex;

        for(char ch = 'a'; ch <= 'z'; ch++) {
            firstIndex = s.indexOf(ch);
            if(firstIndex != -1 && firstIndex == s.lastIndexOf(ch))
                min = Math.min(min, firstIndex);
        }

        return min == s.length() ? -1 : min;
    }

    public int firstUniqChar1(String s) {
        int[] uniqIndexes = new int[26];
        int i = -1, ind, min = s.length();

        Arrays.fill(uniqIndexes, -2);

        for(char ch : s.toCharArray()) {
            i++;
            ind = ch - 'a';

            if(uniqIndexes[ind] >= -1) {
                uniqIndexes[ind] = -1;
                continue;
            }
            
            uniqIndexes[ind] = i;            
        }

        for(i = 0; i < 26; i++)
            if(uniqIndexes[i] >= 0)
                min = Math.min(min, uniqIndexes[i]);
        
        return min == s.length() ? -1 : min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
        System.out.println(s.firstUniqChar("aabb"));
    }
}
