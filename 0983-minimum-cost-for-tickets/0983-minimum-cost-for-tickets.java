class Solution {
    HashMap<List<Integer>,Integer> hm;
    public int mincostTickets(int[] days, int[] costs) {
        hm=new HashMap<>();
        return rec(days,costs,0,0);
    }
    public int rec(int days[],int[] costs,int i,int e){
        if(i==days.length)
            return 0;
        List<Integer> li=toList(i,e);
        if(hm.containsKey(li))
            return hm.get(li);
        if(e>=days[i])
            return rec(days,costs,i+1,e);
        int min=Math.min(costs[0]+rec(days,costs,i+1,days[i]),costs[1]+rec(days,costs,i+1,days[i]+6));
        min=Math.min(min,costs[2]+rec(days,costs,i+1,days[i]+29));
        hm.put(li,min);
        return min;
    }
    public List<Integer> toList(int i,int e){
        List<Integer> li=new ArrayList<Integer>();
        li.add(i);
        li.add(e);
        return li;
    }
}