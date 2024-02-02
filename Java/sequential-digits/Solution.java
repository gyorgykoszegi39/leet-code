import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        int[] nums = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};

        List<Integer> result = new ArrayList<>();
        for(int num : nums) {
            if(num > high)
                return result;

            if(num >= low)
                result.add(num);
        }

        return result;
    }
    public List<Integer> sequentialDigits1(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int add = 11, start = 1, num;
        for(int i = 2; i <= 9; i++) {
            start *= 10;
            start += i;
            num = start;
            for(int j = 0; j <= 9 - i; j++) {
                if(num > high)
                    return result;

                if(num >= low)
                    result.add(num);
                num += add;
            }

            add *= 10;
            add++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(Integer num : s.sequentialDigits(1, 999999999))
            System.out.print(num +  ", ");
    }
}
