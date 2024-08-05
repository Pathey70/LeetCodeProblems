class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Double> map=new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++)
        {
            map.put(position[i],(target-position[i]-0.0)/speed[i]);
        }
        
        double current=0;
        int groups=0;
        for(Double time:map.values())
        {
            //double time=map.get(i);
            if(time>current)
            {
                groups++;
                current=time;
            }
            
        }
        
        return groups;
    }
}