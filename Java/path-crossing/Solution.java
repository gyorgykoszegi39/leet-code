import java.util.HashSet;

public class Solution {
    
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        HashSet<Pair> coords = new HashMap<>();
        Pair key;
        coords.add(new Coordinate(x, y));

        for(char ch : path.toCharArray()) {
            switch(ch) { 
                case 'N' -> y++; 
                case 'S' -> y--; 
                case 'E' -> x++; 
                case 'W' -> x--; 
            }
            key = new Coordinate(x, y);
            if(coords.contains(key))
                return true;
            
            coords.put(key, true);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPathCrossing("NES"));
        System.out.println(s.isPathCrossing("NESWW"));
    }
}
