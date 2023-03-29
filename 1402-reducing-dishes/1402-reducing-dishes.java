class Solution {
    int ans=0;
    HashMap<List<Integer>,Integer> map;
    public int maxSatisfaction(int[] satisfaction) {
        map=new HashMap<>();
        Arrays.sort(satisfaction);
        return rec(satisfaction,0,1);
        
    }
    public int rec(int[] satisfaction,int i,int o){
        if(i==satisfaction.length)
            return 0;
        List<Integer> li=toList(i,o);
        if(map.containsKey(li))
            return map.get(li);
        int max=Math.max(o*satisfaction[i]+rec(satisfaction,i+1,o+1),rec(satisfaction,i+1,o));
        map.put(li,max);
        return max;
    }
    public List<Integer> toList(int i,int e){
        List<Integer> li=new ArrayList<Integer>();
        li.add(i);
        li.add(e);
        return li;
    }
}