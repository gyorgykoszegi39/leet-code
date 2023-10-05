import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int count1 = 0, num1 = Integer.MAX_VALUE, count2 = 0, num2 = Integer.MAX_VALUE;
        int times = nums.length / 3;
        for(int num : nums) {
            if(num1 == num) {
                count1++;
            } else if(num2 == num) {
                count2++;
            } else if(count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if(count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == num1)
                count1++;
            else if(num == num2)
                count2++;
            
        }

        if(times < count1)
            result.add(num1);
        if(times < count2)
            result.add(num2);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for(Integer num : s.majorityElement(new int[] {3, 2, 3}))
            System.out.println(num);
    }
}
