class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int low=1;
        for(int i=0;i<coins.length;i++){
            if(coins[i]>low)
                break;
            low+=coins[i];
           
        }
        return low;
    }
}