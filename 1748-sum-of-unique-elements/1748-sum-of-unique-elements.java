class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int ans=0;
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()==1)
                ans+=entry.getKey();
        }
        return ans;
    }
}