class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:arr)
            hm.put(s,hm.getOrDefault(s,0)+1);
        String ans="";
        int unique=0;
        for(String s:arr)
        {
            if(hm.get(s)==1)
                unique++;
            if(unique==k)
            {
                ans=s;
                break;
            }
        }
        return ans;
    }
}