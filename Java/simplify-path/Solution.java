import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<String>();
        for(String element : path.split("/")) {
            if(element.equals("..")) {
                if(!st.empty())
                    st.pop();
            } else if(!element.equals(".") && !element.equals("")){
                st.push(element);
            }
        }
                
        if(st.empty()) {
            return "/";
        }

        StringBuilder canonicalPath = new StringBuilder();
        while(!st.empty()) {
            canonicalPath.insert(0, st.pop()).insert(0, "/");
        }
        return canonicalPath.toString();
    }

    public static void main(String args[]) {
        System.out.println("/home/ -> " + Solution.simplifyPath("/home/"));
        System.out.println("/../ -> " + Solution.simplifyPath("/../"));
        System.out.println("/home//foo/ -> " + Solution.simplifyPath("/home//foo/"));
        System.out.println("////asd// -> " + Solution.simplifyPath("////asd//"));
        System.out.println("/a/./b/../../c/ -> " + Solution.simplifyPath("/a/./b/../../c/"));
        System.out.println("/a/../../b/../c//.// -> " + Solution.simplifyPath("/a/../../b/../c//.//"));
        System.out.println("/a//b////c/d//././/.. -> " + Solution.simplifyPath("/a//b////c/d//././/.."));

    }
}
