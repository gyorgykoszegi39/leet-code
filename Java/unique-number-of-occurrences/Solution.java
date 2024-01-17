import java.util.Arrays;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq =  new int[2001];
        boolean[] used = new boolean[1001];
        for(int num : arr) {
            freq[1000 + num]++;
        }

        
        for(int f : freq) {
            if(f > 0 && used[f])
                return false;
            else
                used[f] = true;
        }

        return true;
    }

    public boolean uniqueOccurrences1(int[] arr) {
        int[] freq =  new int[2001];

        for(int num : arr) {
            freq[1000 + num]++;
        }

        Arrays.sort(freq);
        
        for(int i = 1; i < 2001; i++)
            if(freq[i] != 0 && freq[i] == freq[i - 1])
                return false;

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.uniqueOccurrences(new int[] {1, 2, 2, 1, 1, 3}));
        System.out.println(s.uniqueOccurrences(new int[] {1, 2}));
        System.out.println(s.uniqueOccurrences(new int[] {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
