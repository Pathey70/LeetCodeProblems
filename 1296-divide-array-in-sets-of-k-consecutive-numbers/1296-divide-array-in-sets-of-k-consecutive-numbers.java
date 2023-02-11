class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        return isNStraightHand(nums,k);
    }
     public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        for(Integer i:hand){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        while(!hm.isEmpty()){
            int x1=hm.firstKey();
            for(int i=x1;i<x1+groupSize;i++){
                int t1=hm.getOrDefault(i,-1);
                if(t1==-1)
                    return false;
                if(t1==1)
                    hm.remove(i);
                else
                    hm.put(i,t1-1);
            }
        }
        return true;
    }
}