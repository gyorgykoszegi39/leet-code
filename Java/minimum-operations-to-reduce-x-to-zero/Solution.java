
public class Solution {

    public int minOperations(int[] nums, int x) {
        int left = 0, right = nums.length - 1, result = nums.length + 1;

        while(left < right && x - nums[left] >= 0) {
            x -= nums[left];
            left++;
        }

        if(x == 0) {
            result = left - 1;
        }

        if(left == right - 1)
            return x == nums[right] ?  right : -1;

        while(left < right && x >= 0) {

            while(left < right && x >= 0) {
                x -= nums[right];
                right--;

                if(x == 0 && result > left + nums.length - right - 1)
                    result = left + nums.length - right - 1;
            }

            while(left > 0 && x < 0) {
                left--;
                x += nums[left];
            }

            if(x == 0 && result > left + nums.length - right - 1)
                result = left + nums.length - right - 1;
            
        }
        return nums.length + 1 == result ? -1 : result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(new int[] {1000, 1, 1, 2, 3}, 1004));
        System.out.println(s.minOperations(new int[] {1, 1, 3, 2, 3}, 5));
        System.out.println(s.minOperations(new int[] {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));
        System.out.println(s.minOperations(new int[] {6016,5483,541,4325,8149,3515,7865,2209,9623,9763,4052,6540,2123,2074,765,7520,4941,5290,5868,6150,6006,6077,2856,7826,9119}, 31841));
        System.out.println(s.minOperations(new int[] {4, 1, 1, 1}, 3));
        System.out.println(s.minOperations(new int[] {1, 1, 1}, 3));
        System.out.println(s.minOperations(new int[] {1, 1, 3, 2, 5}, 5));
        System.out.println(s.minOperations(new int[] {5, 6, 7, 8, 9}, 4));
        System.out.println(s.minOperations(new int[] {1, 1, 4, 2, 3}, 5));
        System.out.println(s.minOperations(new int[] {5, 5, 3, 2, 20, 1, 1 ,3}, 10));
        System.out.println(s.minOperations(new int[] {5, 5, 3, 2, 20, 1, 1, 3}, 1));
        System.out.println(s.minOperations(new int[] {3, 2, 20, 1, 1, 3}, 10));
    }
    
}
