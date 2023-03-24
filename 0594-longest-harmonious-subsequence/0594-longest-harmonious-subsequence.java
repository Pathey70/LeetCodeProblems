class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key=entry.getKey();
            if(hm.containsKey(key+1)){
                ans=Math.max(ans,entry.getValue()+hm.get(key+1));
            }
        }
        return ans;
    }
}