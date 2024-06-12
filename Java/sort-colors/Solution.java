public class Solution {
    public void sortColors(int[] nums) {
        int countRed = 0, countWhite = 0;

        for(int color : nums) {
            if(color == 0)
                countRed++;
            else if(color == 1)
                countWhite++;
        }

        setColor(nums, 0, countRed, 0);
        setColor(nums, countRed, countRed + countWhite, 1);
        setColor(nums, countRed + countWhite, nums.length, 2);

    }

    void setColor(int[] nums, int start, int end, int color) {
        for(int i = start; i < end; i++)
            nums[i] = color;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] colors = new int [] {2, 0, 2, 1, 1, 0};
        s.sortColors(colors);

        for(int color : colors)
            System.out.print(color + " ");
    }
}
