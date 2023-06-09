public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int i = 0, mid = n / 2, j = n -1;

        if(target < letters[0] || target > letters[n - 1])
            return letters[0];
        
        while(i <= j) {
            mid = (i + j) / 2;
            if(letters[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return letters[i];
    }

    public static void main(String[] args) {
        System.out.println(Solution.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'a'));
        System.out.println(Solution.nextGreatestLetter(new char[] {'c', 'f', 'j'}, 'c'));
        System.out.println(Solution.nextGreatestLetter(new char[] {'c', 'c', 'j'}, 'c'));
        System.out.println(Solution.nextGreatestLetter(new char[] {'x', 'x', 'y', 'y'}, 'z'));
    }
}
