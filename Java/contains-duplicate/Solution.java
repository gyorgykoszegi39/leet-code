import java.util.HashSet;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(Integer num: nums) {
            if(!set.add(num))
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[] {1, 2, 3, 2}));
    }
}
