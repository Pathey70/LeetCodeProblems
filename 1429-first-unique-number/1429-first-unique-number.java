class FirstUnique {

    HashMap<Integer,Integer> hm;
    Queue<Integer> queue;
    public FirstUnique(int[] nums) {
        hm=new HashMap<>();
        queue=new LinkedList<>();
        for(int i=0;i<nums.length;i++)
        {
            queue.add(nums[i]);
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
    }
    
    public int showFirstUnique() {
        
        while(queue.size()>0&&hm.get(queue.peek())>1)
            queue.poll();
        
        if(queue.size()==0)
            return -1;
        return queue.peek();
    }
    
    public void add(int value) {
        
        queue.add(value);
        hm.put(value,hm.getOrDefault(value,0)+1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */