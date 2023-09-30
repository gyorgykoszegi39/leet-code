import java.util.LinkedList;
import java.util.Deque;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Deque<Integer> thirdStack = new LinkedList<>();

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < third)
                return true;

            while(!thirdStack.isEmpty() && thirdStack.peek() < nums[i])
                third = thirdStack.pop();
            
            thirdStack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.find132pattern(new int[] {3, 1, 4, 2}));
        System.out.println(s.find132pattern(new int[] {1, 2, 3, 4}));
    }
}
