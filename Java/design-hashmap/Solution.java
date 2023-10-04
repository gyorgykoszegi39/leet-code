class MyHashMap {
    private final Node[] nodes;
    private final static int size = 10000;

    public MyHashMap() {
        nodes = new Node[10001];
    }

    public void put(int key, int value) {
        Node node = findNode(key);

        if(node != null) {
            node.value = value;
        } else {
            Node nextNode = nodes[key % size];
            nodes[key % size] = new Node(key, value);
            nodes[key % size].nextNode = nextNode;
        }
    }

    public int get(int key) {
        Node node = findNode(key);
        return node == null ? -1 :  node.value;
    }

    public void remove(int key) {
        Node node = nodes[key % size];
        if(node == null)
            return;

        if(node.key == key) {
            nodes[key % size] = node.nextNode;
            return;
        }
        while(node.nextNode != null && node.nextNode.key != key) {
            node = node.nextNode;
        }
        if(node.nextNode != null)
            node.nextNode = node.nextNode.nextNode;
    }

    private Node findNode(int key) {
        Node node = nodes[key % size];

        while(node != null) {
            if(node.key == key) {
                return node;
            }
            node = node.nextNode;
        }
        return null; 
    }
}

class Node {
    int key, value;
    Node nextNode;

    Node(int k, int v) {
        key = k;
        value = v;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.remove(1);
        obj.put(1, 5);
        obj.put(501, 6);
        obj.put(1001, 7);
        obj.put(1501, 8);
        obj.put(2, 22);
        System.out.println(obj.get(1));
        obj.put(1, 15);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        obj.remove(1);
        obj.remove(2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(501));
        System.out.println(obj.get(1001));
        System.out.println(obj.get(1501));
        System.out.println(obj.get(5));
        System.out.println(obj.get(2));
    }
}
