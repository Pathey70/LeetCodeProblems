class MRUQueue {

    List<Integer> li;
    public MRUQueue(int n) {
        li=new ArrayList<>();
        for(int i=0;i<n;i++)
            li.add(i+1);
    }
    
    public int fetch(int k) {
        int t1=li.get(k-1);
        li.remove(k-1);
        li.add(t1);
        return t1;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */