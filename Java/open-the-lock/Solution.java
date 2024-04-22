import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Solution {    
    public int openLock(String[] deadends, String target) {
        int count = 0, n;
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String next, prev, curr;
        
        Collections.addAll(set, deadends);

        if(set.contains("0000"))
            return -1;
        set.add("0000");
        queue.offer("0000");
        while(!queue.isEmpty()) {
            n = queue.size();
            
            while(n != 0) {
                curr = queue.poll();
                if(curr.equals(target)) {
                    return count;
                }
                
                for(int i = 0; i < 4; i++) {
                    next = increase(curr.toCharArray(), i);
                    prev = decrease(curr.toCharArray(), i);
                    
                    if(!set.contains(next)) {
                        set.add(next);
                        queue.offer(next);
                    }
                    if(!set.contains(prev)) {
                        set.add(prev);
                        queue.offer(prev);
                    }
                }
                n--;
            }

            count++;
        }
        
        return -1;
    }
    
    private String increase(char[] chars, int i) {
                
        chars[i] = chars[i] == '9' ? '0' :(char)(chars[i] + 1);

        return new String(chars);
    }
    
    private String decrease(char[] chars, int i) {
        chars[i] = chars[i] == '0' ? '9' :(char)(chars[i] - 1);
        
        return new String(chars);
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.openLock(new String[] {"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
