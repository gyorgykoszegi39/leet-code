import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String makeGood(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;

        stringBuilder.append(s);
        while(i < stringBuilder.length()) {
            if(Math.abs(stringBuilder.charAt(i) - stringBuilder.charAt(i - 1)) == 32) {
                stringBuilder.delete(i - 1, i + 1);
                if(i > 1)
                    i--;
            }
            else
                i++;
        }
        
        return stringBuilder.toString();
    }

    public String makeGood1(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> goodCharactersQue = new ArrayDeque<>();
        goodCharactersQue.add(' ');            

        for(char ch : s.toCharArray()) {
            if(Math.abs(goodCharactersQue.peekLast() - ch) == 32)
                goodCharactersQue.pollLast();
            else
                goodCharactersQue.add(ch);            
        }

        StringBuilder stringBuilder = new StringBuilder();
        goodCharactersQue.poll();
        while(!goodCharactersQue.isEmpty())
            stringBuilder.append(goodCharactersQue.poll());

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.makeGood("leEeetcode"));
        System.out.println(s.makeGood("abBAcC"));
        System.out.println(s.makeGood("s"));
        System.out.println(s.makeGood("NROornwPFOBbofpWMm"));
        System.out.println(s.makeGood("Pp"));
    }
}