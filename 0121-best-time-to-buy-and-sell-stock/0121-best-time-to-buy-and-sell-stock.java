class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int currentMin=Integer.MAX_VALUE;
        //int currentMax=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<currentMin)
                currentMin=prices[i];
            else if(prices[i]-currentMin>profit)
                profit=prices[i]-currentMin;
        }
        return profit;
    }
}