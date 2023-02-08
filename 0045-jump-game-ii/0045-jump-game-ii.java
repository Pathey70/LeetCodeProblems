class Solution {
    public int jump(int[] nums) {
        int ans[]=new int[nums.length];
        //ans[nums.length-2]=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            int t=nums[i];
            if(t==0)
            {
                ans[i]=-1;
                continue;
            }
            int min=Integer.MAX_VALUE;
            if(ans[i+1]!=-1)
                min=ans[i+1];
            boolean flag=false;
            for(int j=i+1;j<i+t+1&&j<nums.length;j++)
            {
                //System.out.println(i+" "+j);
                if(ans[j]!=-1)
                flag=true;
                if(ans[j]<min&&ans[j]!=-1)
                {
                    min=ans[j];
                    //flag=true;
                }
            }
            if(!flag)
            {
                if(nums[i]+i>=nums.length-1)
                {
                    ans[i]=1;
                }
                else
                    ans[i]=-1;
            }
            else
            ans[i]=1+min;
            System.out.println(ans[i]);
        }
        
        return ans[0];
    }
}