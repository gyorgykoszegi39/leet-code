public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0, count = 0;
        for (char task : tasks)
            freq[task - 'A']++;
        
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                count = 1;
            } else if (f == maxFreq) {
                count++;
            }

        }
        
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + count);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(s.leastInterval(new char[] {'A', 'C', 'A', 'B', 'D', 'B'}, 1));
    }
}
