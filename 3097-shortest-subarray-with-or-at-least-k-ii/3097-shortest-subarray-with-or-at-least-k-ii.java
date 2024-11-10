class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int right=0;
        int left=0;
        int bitCount[]=new int[32];
        int currentNum=0;
        int ans=Integer.MAX_VALUE;
        while(right<n)
        {
            int bits[]=getBits(nums[right]);
            for(int i=0;i<32;i++)
            {
                bitCount[i]+=bits[i];
            }
            currentNum=currentNum|nums[right];
            while(currentNum>=k&&left<=right)
            {
                ans=Math.min(ans,right-left+1);
                bits=getBits(nums[left]);
                for(int i=0;i<32;i++)
                {
                    bitCount[i]-=bits[i];
                    if(bitCount[i]==0&&bits[i]==1)
                    {
                        currentNum-=(int)(Math.pow(2,i));
                    }
                }
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int[] getBits(int n)
    {
        int bits[]=new int[32];
        int i=0;
        while(n!=0)
        {
            bits[i]=n%2;
            n=n/2;
            i++;
        }
        return bits;
    }
    
    public int getNumber(int bits[])
    {
        int num=0;
        for(int i=0;i<bits.length;i++)
        {
            num+=(int)(Math.pow(2,i)*bits[i]);
        }
        return num;
    }
}