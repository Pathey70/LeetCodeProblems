/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int heightFinal=0;
    boolean leaf=false;
    public boolean isCompleteTree(TreeNode root) {
       /* if(root==null)
        {
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int count=0;
        boolean full=true;
        int fullCount=-1;
        int fullLevel=-1;
        while(queue.isEmpty()==false)
        {
            TreeNode element=queue.remove();
            count++;
            TreeNode left=element.left;
            TreeNode right=element.right;
            System.out.println(count);
            if(element.left==null&&element.right!=null)
                return false;
            else if(element.left!=null&&element.right==null)
            {
                if(full)
                {
                    full=false;
                    fullCount=count;
                    fullLevel=(int )(Math.log(count)/Math.log(2));
                    //count++;
                    queue.add(element.left);
                    System.out.println(fullLevel+" fullLevel");
                }
                else
                {
                    return false;
                }
            }
            else if(left==null&&right==null)
            {
                if(full)
                {
                    full=false;
                    fullCount=count;
                    fullLevel=(int )(Math.log(count)/Math.log(2));
                    System.out.println(fullLevel);
                }
                
            }
            else
            {
                if(!full)
                {
                    return false;
                }
                queue.add(element.left);
                queue.add(element.right);
            }
            
        }*/
        if(root==null)
        {
            return true;
        }
        boolean stoppage=false;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(stoppage){
                if(node.left!=null||node.right!=null)
                    return false;
            }
            else{
                /*if(node.left==null||node.right==null)
                {   
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    else{
                        stoppage=true;
                    }
                    if(node.right!=null)
                    {   
                        if(stoppage)
                            return false;
                        stoppage=true;
                        queue.add(node.right);
                    }
                }
                else{
                    queue.add(node.left);
                    queue.add(node.right);
                }
                */
                if(node.left!=null)
                    queue.add(node.left);
                else 
                    stoppage=true;
                
                if(node.right!=null)
                {
                    if(stoppage)
                        return false;
                    queue.add(node.right);
                }
                else{
                    stoppage=true;
                }
            }
        }
        return true;
        
    }
    
}