
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, indexOfVal = nums.length - 1, swap;
        while(i <= indexOfVal) {

            if(nums[i] == val) {
                while(nums[indexOfVal] == val) {
                    indexOfVal--;

                    if(i > indexOfVal)
                        return indexOfVal + 1;
                }
                swap = nums[indexOfVal];
                nums[indexOfVal] = nums[i];
                nums[i] = swap;
                indexOfVal--;
            }
            i++;
        }
        return indexOfVal + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeElement(new int[] {}, 0));
        System.out.println(s.removeElement(new int[] {1}, 1));
        System.out.println(s.removeElement(new int[] {3, 3}, 3));
        System.out.println(s.removeElement(new int[] {3, 2, 2, 3}, 3));
        System.out.println(s.removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
    
}
