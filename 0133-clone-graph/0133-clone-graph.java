/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        HashMap<Integer,Node> hm=new HashMap();
        return clone(node,hm);
    }
    public Node clone(Node node,HashMap<Integer,Node> hm)
    {
        if(node==null)
            return null;
        if(hm.containsKey(node.val))
            return hm.get(node.val);
        Node cp=new Node(node.val);
        hm.put(node.val,cp);
        for(int i=0;i<node.neighbors.size();i++)
        {
            cp.neighbors.add(clone(node.neighbors.get(i),hm));
        }
        return cp;
    }
}