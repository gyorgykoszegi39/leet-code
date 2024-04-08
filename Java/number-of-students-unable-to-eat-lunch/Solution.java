public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int countSquareSandwiches = 0;

        for(int sandwiche : students)
            countSquareSandwiches += sandwiche;

        int countCircleSandwiches = students.length - countSquareSandwiches;
        for(int sandwiche : sandwiches) {
            countSquareSandwiches -= sandwiche;
            countCircleSandwiches -= 1 - sandwiche;

            if(countCircleSandwiches < 0 || countSquareSandwiches < 0)
                return 1 + countCircleSandwiches + countSquareSandwiches;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countStudents(new int[] {1, 1, 0, 0}, new int[] { 0, 1, 0, 1}));
        System.out.println(s.countStudents(new int[] {1, 1, 1, 0, 0, 1}, new int[] { 1, 0, 0, 0, 1, 1}));
    }
}
