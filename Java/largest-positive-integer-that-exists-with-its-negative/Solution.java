public class Solution {
    public int findMaxK(int[] nums) {
        int[] freq = new int[1001];
        int max = -1, abs;

        for(int num : nums) {
            if(num < 0) {
                abs = Math.abs(num);
                if(freq[abs] == abs && abs > max) {
                    max = abs;
                }
                
                freq[abs] = num;
            } else {
                if(freq[num] == -num && num > max) {
                    max = num;
                }

                freq[num] = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMaxK(new int[] {-1, 2, -3, 3}));
        System.out.println(s.findMaxK(new int[] {-1, 10, 6, 7, -7, 1}));
        System.out.println(s.findMaxK(new int[] {-10, 8, 6, 7, -2, -3}));
    }
}
