class Solution {
    HashMap<String,int[]> hm;
    HashMap<String,int[]> hm1;
    public int stoneGameII(int[] piles) {
        int m=1;
        int rIndex=0;
        hm=new HashMap<>();
        hm1=new HashMap<>();
        int ans[]=play(piles,true,m,rIndex);
        return ans[0];
    }
    
    public int[] play(int[] piles,boolean player,int m,int rIndex)
    {
        int ans[]=new int[2];
        if(rIndex>piles.length-1)
        {
           return ans;
        }
        String s=Integer.toString(m)+" "+Integer.toString(rIndex);
        if(player&&hm.containsKey(s))
            return hm.get(s);
        if(!player&&hm1.containsKey(s))
            return hm1.get(s);
        int max=0;
        int total=0;
        for(int i=rIndex;i<Math.min(rIndex+2*m,piles.length);i++)
        {
            total+=piles[i];
            int res[]=play(piles,!player,Math.max(i-rIndex+1,m),i+1);
            if(player)
            {
                if(total+res[0]>max)
                {
                    max=total+res[0];
                    ans[0]=max;
                    ans[1]=res[1];
                }
            }
            else{
                if(total+res[1]>max)
                {
                    max=total+res[1];
                    ans[1]=max;
                    ans[0]=res[0];
                }
            }
        }
        if(player)
            hm.put(s,ans);
        else
            hm1.put(s,ans);
        return ans;
    }
}