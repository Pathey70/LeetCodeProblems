class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Double> map=new TreeMap<>();
        for(int i=0;i<position.length;i++)
        {
            map.put(position[i],(target-position[i]-0.0)/speed[i]);
        }
        Set<Integer> hs=map.descendingKeySet();
        double current=0;
        int groups=0;
        for(Integer i:hs)
        {
            double time=map.get(i);
            if(time>current)
            {
                groups++;
                current=time;
            }
            
        }
        
        return groups;
    }
}