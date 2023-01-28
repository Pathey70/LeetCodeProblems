class SummaryRanges {
    List<List<Integer>> li;
    HashSet<Integer> hs;
    public SummaryRanges() {
        li=new ArrayList<List<Integer>>();
        hs=new HashSet<>();
    }
    
    public void addNum(int value) {
        if(hs.contains(value))
            return;
        hs.add(value);
        int i=search(value);
        //System.out.println(i);
        if(i==-1){
            if(li.size()!=0&&li.get(0).get(0)==value+1){
                li.get(0).set(0,value);
            }
            else{
                List<Integer> e=new ArrayList<>();
                e.add(value);
                e.add(value);
                li.add(0,e);
            }
        }
        else{
            if(value==li.get(i).get(1)+1){
                //Left merging
                if(i+1<li.size()&&value==li.get(i+1).get(0)-1){
                    li.get(i).set(1,li.get(i+1).get(1));  //Merging both left and right
                    li.remove(i+1);
                }
                else{
                    li.get(i).set(1,value); //Only left merging
                }
            }
            else{
                if(i+1<li.size()&&value==li.get(i+1).get(0)-1){
                    li.get(i+1).set(0,value);  //Merging right
                    
                }
                else{
                    List<Integer> e=new ArrayList<>(); //No merging
                    e.add(value);
                    e.add(value);
                    li.add(i+1,e);
                }
                
            }
            
            
            
        }
        
    }
    public int search(int value){
        int start=0;
        int end=li.size()-1;
        int result=0;
        if(li.size()==0||value<li.get(start).get(0))
            return -1;
        while(start<=end){
            int mid=(start+end)/2;
            if(li.get(mid).get(0)<value){
                result=mid;
                start=mid+1;
            }
            else {
                
                end=mid-1;
            }
            
        }
        return result;
        
        
    }
    public int[][] getIntervals() {
        int ans[][]=new int[li.size()][2];
        for(int i=0;i<li.size();i++){
            ans[i][0]=li.get(i).get(0);
            ans[i][1]=li.get(i).get(1);
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */