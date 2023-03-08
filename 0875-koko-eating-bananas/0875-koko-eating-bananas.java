class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*int sum=0;
        for(int i=0;i<piles.length;i++)
        {
            sum+=piles[i];
        }
        double avg=sum*1.0/h;
        double deficit=0;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]<avg)
            {
                deficit+=(avg-piles[i]);
            }
        }
        return (int )Math.ceil(deficit/h+avg);*/
        int low=1;
        int high=1000000000;
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int hours=0;
            for(int i=0;i<piles.length;i++){
                hours+=(Math.ceil((1.0*piles[i])/mid));
            }
            if(hours<=h)
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}