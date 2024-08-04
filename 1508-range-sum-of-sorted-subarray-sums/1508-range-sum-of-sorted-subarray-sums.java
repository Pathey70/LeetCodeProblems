class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> li=new ArrayList<>();
        int mod=1000000007;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=nums[j];
                li.add(sum);
                sum%=mod;
            }
        }
        Collections.sort(li);
        int ans=0;
        for(int i=left-1;i<right;i++)
        {
            ans+=li.get(i);
            ans%=mod;
        }
        return ans;
    }
}