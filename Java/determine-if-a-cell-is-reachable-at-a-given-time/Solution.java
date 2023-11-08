public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int xdist = Math.abs(sx - fx), fdist = Math.abs(sy - fy);

        if(xdist == 0 && fdist == 0 && t == 1)
            return false;
        
        return Math.max(xdist, fdist) <= t;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(s.isReachableAtTime(3, 1, 7, 3, 3));
        System.out.println(s.isReachableAtTime(1, 1, 1, 3, 2));

    }
}
