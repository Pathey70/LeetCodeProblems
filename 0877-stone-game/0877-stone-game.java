class Solution {
    HashMap<String,int[]> hm;
    HashMap<String,int[]> hm1;
    public boolean stoneGame(int[] piles) {
        hm=new HashMap<>();
        hm1=new HashMap<>();
        int ans[]=play(piles,0,piles.length-1,true);
        return ans[0] > ans[1] ? true :false;
    }
    
    public int[] play(int[] piles,int left,int right,boolean player)
    {
        String s=Integer.toString(left)+" "+Integer.toString(right);
        if(player&&hm.containsKey(s))
            return hm.get(s);
        if(!player&&hm1.containsKey(s))
            return hm1.get(s);
        int ans[]=new int[2];
        if(left>right)
            return ans;
        int res[]=play(piles,left+1,right,!player);
        int res1[]=play(piles,left,right-1,!player);
        if(player)
        {
            if(res[0]+piles[left]>res1[0]+piles[right])
            {
                ans[0]=res[0]+piles[left];
                ans[1]=res[1];
            }
            else{
                ans[0]=res1[0]+piles[right];
                ans[1]=res1[1];
            }
        }else{
            if(res[1]+piles[left]>res1[1]+piles[right])
            {
                ans[0]=res[0];
                ans[1]=res[1]+piles[left];
            }else{
                ans[0]=res1[0];
                ans[1]=res1[1]+piles[right];
            }
        }
        if(player)
            hm.put(s,ans);
        else
            hm1.put(s,ans);
        return ans;
    }
}