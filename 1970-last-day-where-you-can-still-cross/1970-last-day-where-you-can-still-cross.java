class Solution {
    HashMap<Integer,GridInfo> hm;
    public int latestDayToCross(int row, int col, int[][] cells) {
        hm=new HashMap<>();
        int i=0;
        while(i<cells.length)
        {
            int x=cells[i][0]-1;
            int y=cells[i][1]-1;
            GridInfo gridObj=new GridInfo(x,y,col);
            hm.put(x*col+y,gridObj);
            List<Integer> neighbors=getNeighbors(x,y,col,row);
            //System.out.println(neighbors);
            for(Integer neighbor:neighbors){
                if(hm.containsKey(neighbor)){
                    union(gridObj,hm.get(neighbor),col);
                }
            }
            GridInfo parent=hm.get(findParent(gridObj,col));
            if(parent.leftX==0&&parent.rightX==col-1){
                return i;
            }
            i++;
        }
        return i;
    }
    public void union(GridInfo grid1,GridInfo grid2,int c){
        int p1=findParent(grid1,c);
        int p2=findParent(grid2,c);
        //System.out.println(grid1.x+" "+grid1.y+" "+grid2.x+" "+grid2.y);
        if(hm.get(p1).rank>hm.get(p2).rank){
           doUnion(p1,p2);
        }else{
           doUnion(p2,p1);
        }
    }
    public void doUnion(int p1,int p2){
         GridInfo parent=hm.get(p1);
         GridInfo child=hm.get(p2);
         child.parent=p1;
         parent.leftX=Math.min(parent.leftX,child.leftX);
         parent.rightX=Math.max(parent.rightX,child.rightX);
         parent.rank+=child.rank;
         //System.out.println(parent.leftX+" "+parent.rightX+" "+parent.x+" "+parent.y+" "+child.x+" "+child.y);
    }
    public int findParent(GridInfo grid,int c){
        if(grid.parent==grid.x*c+grid.y){
            return grid.parent;
        }else{
            grid.parent=findParent(hm.get(grid.parent),c);
            return grid.parent;
        }
    }
    public List<Integer> getNeighbors(int x,int y,int c,int r){
        List<Integer> li=new ArrayList<>();
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++){
                if(i>=0&&j>=0&&j<c&&i<r){
                    if(i!=x||j!=y)
                        li.add(i*c+j);
                }
            }
        }
        return li;
    }
}
class GridInfo{
    int parent;
    int leftX;
    int rightX;
    int x;
    int y;
    int rank;
    public GridInfo(int x,int y,int c){
        this.x=x;
        this.y=y;
        this.parent=x*c+y;
        leftX=y;
        rightX=y;
        this.rank=1;
    }
}