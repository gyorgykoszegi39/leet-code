public class Solution {
    
    public int minCost(String colors, int[] neededTime) {
        char[] chars = colors.toCharArray();
        int sum = 0, max = neededTime[0], i, n = chars.length;
        
        for(i = 1; i < n; i++) {
            if(chars[i - 1] == chars[i]) {
                if(max < neededTime[i]) {
                    sum += max;
                    max = neededTime[i];
                } else
                    sum += neededTime[i];
            } else 
                max = neededTime[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minCost("abaac", new int[] {1, 2, 3, 4, 5}));
        System.out.println(s.minCost("abc", new int[] {1, 2, 3}));
        System.out.println(s.minCost("aabaa", new int[] {1, 2, 3, 4, 1}));
    }
}
