import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        Solution s=new Solution();
        Node result=s.cloneGraph(n1);
        System.out.println("finish");
    }
    HashMap<Node,Node> mem=new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node cur){
        if(cur==null) return cur;
        if(mem.get(cur)!=null){
            return mem.get(cur);
        }
        Node newNode=new Node(cur.val,new ArrayList<>());
        mem.put(cur,newNode);
        for(Node n : cur.neighbors){
            newNode.neighbors.add(dfs(n));
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
