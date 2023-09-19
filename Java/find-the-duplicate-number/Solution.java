
public class Solution {

    public int findDuplicate(int[] nums) {
        int j, i = nums[0];
        
        while(nums[i] != 0) {
            j = i;
            i = nums[i];
            nums[j] = 0;
        }
   
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicate(new int[] {1, 3, 4, 2, 2}));
    }
}
