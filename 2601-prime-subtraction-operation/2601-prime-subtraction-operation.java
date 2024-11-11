class Solution {
    List<Integer> primes;
    public boolean primeSubOperation(int[] nums) {
        primes=new ArrayList<>();
        for(int i=2;i<=1000;i++)
        {
            if(isPrime(i))
                primes.add(i);
        }
        int n=nums.length;
        int j=n-2;
        while(j>=0)
        {
            if(nums[j]>=nums[j+1])
            {
                int diff=nums[j]-nums[j+1]+1;
                int idx=isAvailable(diff);
                if(idx!=-1&&primes.get(idx)<nums[j])
                {
                    nums[j]-=primes.get(idx);
                   // System.out.println(nums[j]);
                }else{
                    return false;
                }
            }
            j--;
        }
        return true;
    }
    public int isAvailable(int diff)
    {
        int right=primes.size()-1;
        int left=0;
        if(diff>primes.get(right))
            return -1;
        int ans=-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(primes.get(mid)>=diff)
            {
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    
    public boolean isPrime(int n)
    {
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
}