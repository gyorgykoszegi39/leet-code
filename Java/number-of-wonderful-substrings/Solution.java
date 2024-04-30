public class Solution {
    public long wonderfulSubstrings(String word) {
        int[] count = new int[1024];
        int mask = 0;
        long result = 0;

        count[0] = 1;
        for (char ch : word.toCharArray()) {
            mask ^= 1 << (ch - 'a');
            result += count[mask];
            for (int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }
            count[mask]++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        System.out.println(s.wonderfulSubstrings("aba"));
        System.out.println(s.wonderfulSubstrings("aabb"));
        System.out.println(s.wonderfulSubstrings("he"));
    }
}
