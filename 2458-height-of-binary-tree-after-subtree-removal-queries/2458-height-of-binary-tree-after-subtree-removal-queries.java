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
    int treeDepth=0;
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer,int[]> nodeInfoMap=new HashMap<>();
        List<int[]> depthList=new ArrayList<>();
        dfs(root,nodeInfoMap,depthList,0);
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int nodeInfo[]=nodeInfoMap.get(queries[i]);
            int levelData[]=depthList.get(nodeInfo[0]);
            if(nodeInfo[1]==levelData[0])
            {
                ans[i]=nodeInfo[0]+levelData[1]-1;
            }
            else
                ans[i]=nodeInfo[0]+levelData[0]-1;
        }
        return ans;
    }
  
    public int dfs(TreeNode node,HashMap<Integer,int[]> nodeInfoMap,List<int[]> depthList,int level)
    {
        if(node==null)
            return 0;
        if(depthList.size()<=level)
        {
            int newLevel[]=new int[2];
            depthList.add(newLevel);
        }
        int levelData[]=depthList.get(level);
        int leftDepth=dfs(node.left,nodeInfoMap,depthList,level+1);
        int rightDepth=dfs(node.right,nodeInfoMap,depthList,level+1);
        int nodeDepth=Math.max(leftDepth+1,rightDepth+1);  
        if(nodeDepth>=levelData[0])
        {
            levelData[1]=levelData[0];
            levelData[0]=nodeDepth;
        }else if(nodeDepth>levelData[1])
        {
            levelData[1]=nodeDepth;
        }
        depthList.set(level,levelData);
        int nodeInfo[]=new int[2];
        nodeInfo[0]=level;
        nodeInfo[1]=nodeDepth;
        nodeInfoMap.put(node.val,nodeInfo);
        return nodeDepth;
    }
}