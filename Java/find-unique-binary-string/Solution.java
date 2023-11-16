
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '0' ? '1' : '0'); 
        }
        
        return result.toString();  
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findDifferentBinaryString(new String[] {"01", "10"}));
        System.out.println(s.findDifferentBinaryString(new String[] {"111", "011", "001"}));

    }
}
