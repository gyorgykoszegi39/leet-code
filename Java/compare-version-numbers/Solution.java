public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int i = 0, j = 0, v1, v2;

        while(i < version1Array.length && j < version2Array.length) {
            v1 = Integer.valueOf(version1Array[i]);
            v2 = Integer.valueOf(version2Array[j]);
            if(v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }

            i++;
            j++;
        }
    
        while(i < version1Array.length) {
            if(Integer.valueOf(version1Array[i]) != 0)
                return 1;
            i++;
        }
        while(j < version2Array.length) {
            if(Integer.valueOf(version2Array[j]) != 0)
                return -1;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.compareVersion("1.01", "1.001"));
        System.out.println(s.compareVersion("0.1", "1.1"));
        System.out.println(s.compareVersion("1.0", "1.0.0"));
        System.out.println(s.compareVersion("1", "1.1"));
    }
}
