import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node srcNode = head;
        Node result = new Node(0);
        for (; srcNode != null; ) {
            map.put(srcNode, new Node(srcNode.val));
            srcNode = srcNode.next;
        }
        srcNode = head;
        Node dummy = result;

        Node newNode, newNext, newRandom;
        for (; srcNode != null; ) {
            newNode = map.get(srcNode);
            newNext = map.get(srcNode.next);
            newRandom = map.get(srcNode.random);
            newNode.next = newNext;
            newNode.random = newRandom;
            dummy.next = newNode;
            dummy = dummy.next;
            srcNode = srcNode.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node2.random = node2;
        Solution s = new Solution();
        Node node = s.copyRandomList(node1);
        System.out.println(node);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}