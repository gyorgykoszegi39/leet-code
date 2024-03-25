import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length, jump;

        for(int i = 0; i < n; i++) {
            jump = Math.abs(nums[i]) - 1;

            if(nums[jump] < 0)
                result.add(jump + 1);
            nums[jump] *= -1;
        }
        
        return result;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length, jump, nextJump;

        for(int i = 0; i < n; i++) {
            if(nums[i] < 0)
                continue;

            nextJump = nums[i] - 1;
            jump = nextJump;
            while(nextJump > i){
                jump = nextJump;
                nextJump = nums[jump] - 1;
                nums[jump] = -1;
            }

            if(nextJump < 0)
                result.add(jump + 1);
            else if(nums[nextJump] == -1)
                result.add(nextJump + 1);
            else
                nums[nextJump] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int duplicate : s.findDuplicates(new int[] {1, 1, 2}))
            System.out.print(duplicate + " ");
        System.out.println();
        for(int duplicate : s.findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1}))
            System.out.print(duplicate + " ");
            System.out.println();
        for(int duplicate : s.findDuplicates(new int[] {9, 9, 4, 10, 8, 5, 2, 2, 7, 7}))
            System.out.print(duplicate + " ");

    }
}
