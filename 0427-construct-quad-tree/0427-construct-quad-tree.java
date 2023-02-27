/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n=grid.length;
        return generate(grid,0,0,n,n);
    }
    public Node generate(int grid[][],int x1,int y1,int x2,int y2){
        boolean one=false;
        boolean zero=false;
        if(x1>x2||y1>y2)
            return null;
        for(int i=x1;i<x2;i++){
            for(int j=y1;j<y2;j++){
                if(grid[i][j]==1)
                    one=true;
                else
                    zero=true;
                
            }
            if(zero&&one)
                break;
        }
        Node node;
        if(zero&&one)
        {
            int midX=(x2+x1)/2;
            int midY=(y2+y1)/2;
            //System.out.println(midX+" "+midY);
            node=new Node(one,false,generate(grid,x1,y1,midX,midY),generate(grid,x1,midY,midX,y2),generate(grid,midX,y1,x2,midY),generate(grid,midX,midY,x2,y2));
        }
        else{
            node=new Node(one,true);
        }
        return node;
    }
}