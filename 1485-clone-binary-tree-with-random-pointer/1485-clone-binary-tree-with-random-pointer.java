/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node,NodeCopy> cloned;
    public NodeCopy copyRandomBinaryTree(Node root) {
        cloned=new HashMap<>();
        return deepCopy(root);
    }
    public NodeCopy deepCopy(Node root){
        if(root==null)
            return null;
        if(cloned.containsKey(root))
            return cloned.get(root);
        NodeCopy copy=new NodeCopy(root.val);
        cloned.put(root,copy);
        copy.left=deepCopy(root.left);
        copy.right=deepCopy(root.right);
        copy.random=deepCopy(root.random);
        return copy;
    }
}