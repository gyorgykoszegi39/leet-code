public class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        while(left < right && chars[left] == chars[right]) {
            while(left < right && chars[left] == chars[left + 1])
                left++;

            while(left < right && chars[right] == chars[right - 1])
                right--;
            left++;
            right--;
        }

        return  left > right ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minimumLength("ca"));
        System.out.println(s.minimumLength("cabaabac"));
        System.out.println(s.minimumLength("aabccabba"));
        System.out.println(s.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }
}
