class Solution {
    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans=new ArrayList<List<Integer>>();
            permute(nums,0,ans);
        return ans;
    }
    public static void permute(int[] nums,int position,List<List<Integer>> ans)
    {
        if(position==nums.length-1)
        {
            List<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++)
            {
                temp.add(nums[i]);
            }
            ans.add(temp);
        }
        else
        {
            for(int i=position;i<nums.length;i++)
            {
                int k=nums[i];
                nums[i]=nums[position];
                nums[position]=k;
                permute(nums,position+1,ans);
                k=nums[i];
                nums[i]=nums[position];
                nums[position]=k;
            }
        }
    }
    
}