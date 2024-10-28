class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Long,Integer> hm=new HashMap<Long,Integer>();
        int ans=-1;
        for(int i=nums.length-1;i>=0;i--){
            long one=1;
            if(hm.containsKey(one*nums[i]))
                continue;
            
            long square=1*nums[i]*nums[i];
            if(hm.containsKey(square)){
                hm.put(one*nums[i],hm.get(square)+1);
                ans=Math.max(ans,hm.get(square)+1);
            }
            else{
                hm.put(one*nums[i],1);
            }
        }
        return ans;
    }
}