import java.util.Stack;

class MyQueue {
    private Stack<Integer> front, end;

    public MyQueue() {
        front = new Stack<>();
        end = new Stack<>();
    }
    
    public void push(int x) {
        end.push(x);
    }
    
    public int pop() {
        if(front.empty()) {
            while (!end.empty()) {
                front.push(end.pop());
            }
        }

        return front.pop();
    }
    
    public int peek() {
        if(front.empty()) {
            while (!end.empty()) {
                front.push(end.pop());
            }
        }

        return front.peek();
    }
    
    public boolean empty() {
        return front.empty() && end.empty();
    }
}
public class Solution {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(0);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.empty());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.empty());
    }
}
