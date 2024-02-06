import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        String sortedString;
        char[] chars;
        for(String str : strs) {
            chars = str.toCharArray();
            Arrays.sort(chars);
            sortedString = new String(chars);

            groups.computeIfAbsent(sortedString, k -> new ArrayList<String>()).add(chars);
        }

        for(ArrayList<String> value : groups.values())
            result.add(value);

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> result = s.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});

        for(List<String> group : result) {
            for(String value : group)
                System.out.print(value + " ");
            System.out.println();
            System.out.println();
        }
        
    }
}
