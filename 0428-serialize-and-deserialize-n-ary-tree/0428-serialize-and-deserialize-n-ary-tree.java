/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    
    public StringBuilder serial(Node node)
    {
        StringBuilder sb=new StringBuilder();
        if(node==null)
            return sb;
        sb.append(node.val);
        sb.append("-");
        sb.append(node.children.size());
        for(int i=0;i<node.children.size();i++)
        {
            sb.append(",");
            sb.append(serial(node.children.get(i)));
        }
        return sb;
    }
    public String serialize(Node root) {
        
        return serial(root).toString();
        
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length()==0)
            return null;
        String arr[]=data.split(",");
        
        Node dummy=new Node(-1,new ArrayList<Node>());
        //System.out.println(data);
        deserial(arr,0,dummy);
        return dummy.children.get(0);
    }
    
    public int deserial(String arr[],int idx,Node node)
    {
        String entry=arr[idx];
        Node child=new Node(Integer.parseInt(entry.substring(0,entry.indexOf("-"))),new ArrayList<Node>());
        int numChild=Integer.parseInt(entry.substring(entry.indexOf("-")+1));
        node.children.add(child);
        //System.out.println(child.val+" "+idx+" "+node.val);
        idx++;
        for(int i=0;i<numChild;i++)
        {
            idx=deserial(arr,idx,child);
        }
        return idx;
    }
    
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));