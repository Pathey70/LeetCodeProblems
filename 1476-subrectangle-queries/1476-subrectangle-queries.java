class SubrectangleQueries {
    int rectangle[][];
    List<List<Integer>> li;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle=rectangle;
        li=new ArrayList<List<Integer>>();
        //li.add(giveList(0,0,rectangle.length,rectangle[0].length));
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        li.add(0,giveList(row1,col1,row2,col2,newValue));
    }
    
    public int getValue(int row, int col) {
        
        for(List<Integer> list:li){
            if(row>=list.get(0)&&col>=list.get(1)&&row<=list.get(2)&&col<=list.get(3))
                return list.get(4);
        }
        return rectangle[row][col];        
    }
    public List<Integer> giveList(int x1,int y1,int x2,int y2,int val){
        List<Integer> li=new ArrayList<>();
        li.add(x1);
        li.add(y1);
        li.add(x2);
        li.add(y2);
        li.add(val);
        return li;
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */