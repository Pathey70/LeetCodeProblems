class Solution {
    int ans=0;
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int pSum=0,nSum=0;
        for(int i=0;i<n;i++){
            if(satisfaction[i]>0)  
                pSum+=satisfaction[i];
            else
                nSum+=satisfaction[i];
        }
        int i=0;
        int ans=0;
        int count=1;
        while(i<n&&pSum+nSum<0){
            nSum-=satisfaction[i];
            i++;
        }
        while(i<n){
            ans+=satisfaction[i]*count;
            count++;
            i++;
        }
        return ans;
    }
}