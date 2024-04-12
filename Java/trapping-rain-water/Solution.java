public class Solution {
    public int trap(int[] height) {
        int n = height.length, count = 0, left = 0, right = n - 1, elevation;
        int maxElevation = 0, maxElevationIndex = 0;

        for(int i = 0; i < n; i++) {
            if(height[i] > maxElevation) {
                maxElevation = height[i];
                maxElevationIndex = i;
            }
        }
        
        elevation = height[left];
        while(left < maxElevationIndex) {
            if(height[left] > elevation)
                elevation = height[left];

            count += Math.min(maxElevation, elevation) - height[left];
            left++;
        }

        elevation = height[right];
        while(right > maxElevationIndex) {
            if(height[right] > elevation)
                elevation = height[right];

            count += Math.min(maxElevation, elevation) - height[right];
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(s.trap(new int[] {4, 2, 0, 3, 2, 5}));
    }
}
