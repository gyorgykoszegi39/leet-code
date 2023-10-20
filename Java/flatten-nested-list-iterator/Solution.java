import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NestedInteger {
    Deque<Object> deque = new LinkedList<>();
    private boolean isInteger;
    private Integer element;
    private List<NestedInteger> nestedElement;

    public NestedInteger(Integer e) {
        element = e;
        isInteger = true;
    }

    public NestedInteger(List<NestedInteger> e) {
        nestedElement = e;
        isInteger = false;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public Integer getInteger() {
        return element;
    }

    public List<NestedInteger> getList() {
        return nestedElement;
    }


}

class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> queue;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();

        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList) {
        if(!nestedList.isEmpty()) {
            for(NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger())
                    queue.offer(nestedInteger.getInteger());
                else
                    flattenList(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        NestedInteger e1 = new NestedInteger(1);
        NestedInteger e2 = new NestedInteger(2);
        NestedInteger e3 = new NestedInteger(3);
        List<NestedInteger> lNestedIntegers = new ArrayList<>();

        lNestedIntegers.add(e1);
        lNestedIntegers.add(e2);
        lNestedIntegers.add(e3);

    
        NestedIterator i = new NestedIterator(lNestedIntegers);

        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
