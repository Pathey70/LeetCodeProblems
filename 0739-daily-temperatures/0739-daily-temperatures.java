class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int arr[]=new int[71];
        for(int i=0;i<71;i++)
            arr[i]=n;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            int minIdx=n;
            for(int j=temperatures[i]+1-30;j<71;j++)
            {
                minIdx=Math.min(minIdx,arr[j]);
            }
            if(minIdx!=n)
                ans[i]=(minIdx-i);
            else
                ans[i]=0;
            arr[temperatures[i]-30]=i;
        }
        return ans;
    }
}