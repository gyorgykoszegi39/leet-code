import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String destCity(List<List<String>> paths) {

        HashMap<String, String> hm = new HashMap<>();

        for(List<String> path : paths) {
            hm.put(path.get(0), path.get(1));
        }

        String dest = paths.get(0).get(1);
        while(hm.containsKey(dest)) {
            dest = hm.get(dest);
            hm.remove(dest);
        }

        return dest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> paths =new ArrayList<List<String>>();
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        List<String> p3 = new ArrayList<>();
        p1.add("London");
        p1.add("New York");
        p2.add("New York");
        p2.add("Lima");
        p3.add("Lima");
        p3.add("Sao Paulo");

        paths.add(p1);
        paths.add(p2);
        paths.add(p3);

        System.out.println(s.destCity(paths));
    }
}
