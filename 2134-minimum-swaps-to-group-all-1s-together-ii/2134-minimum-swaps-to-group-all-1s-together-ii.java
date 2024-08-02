class Solution {
    public int minSwaps(int[] data) {
        int ones=0;
        int n=data.length;
        for(int i=0;i<n;i++)
            ones+=data[i];
        
        int i=0;
        int j=0;
        int currentCount=0;
        int ans=Integer.MAX_VALUE;
        while(j<ones)
        {
            currentCount+=data[j];
            j++;
        }
        while(i<n)
        {
            ans=Math.min(ans,ones-currentCount);
            currentCount-=data[i];
            currentCount+=data[j%n];
            i++;
            j++;
        }
        return ans;
    }
}