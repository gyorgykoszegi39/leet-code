public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int time = minutesToTest / minutesToDie + 1;
        while(Math.pow(time, pigs) < buckets)
            pigs++;

        return pigs;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.poorPigs(4, 15, 15));
        System.out.println(s.poorPigs(4, 15, 30));
    }
}
