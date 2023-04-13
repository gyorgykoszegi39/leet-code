import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length)
            return false;

        Stack<Integer> st = new Stack<Integer>();

        int poppedIndex = 0;
        for(int i = 0; i < pushed.length; i++) {
            if(pushed[i] == popped[poppedIndex]) {
                poppedIndex++;
                while(!st.empty() && st.peek() == popped[poppedIndex]) {
                    st.pop();
                    poppedIndex++;
                }
            } else {
                st.push(pushed[i]);
            }
        }
        
        return st.empty();
    }

    public static void main(String args[]) {
        int pushed[] = {1, 2, 3, 4, 5};
        int popped[] = {4, 5, 3, 2, 1};
        int popped2[] = {4, 3, 5, 1, 2};

        System.out.println(new Solution().validateStackSequences(pushed, popped));
        System.out.println(new Solution().validateStackSequences(pushed, popped2));

    }
}