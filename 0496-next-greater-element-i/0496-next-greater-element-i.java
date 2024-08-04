class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[]=new int[nums1.length];
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        Stack<Integer> stack=new Stack<Integer>();
        int ref[]=new int[nums2.length];
        hm.put(nums2[0],0);
        stack.push(nums2[0]);
        for(int i=0;i<nums2.length;i++)
            ref[i]=-1;
        for(int j=1;j<nums2.length;j++)
        {
            while(stack.size()>0&&stack.peek()<nums2[j])
            {
                int p=stack.pop();
                ref[hm.get(p)]=nums2[j];
            }
            stack.push(nums2[j]);
            hm.put(nums2[j],j);
        }
        for(int i=0;i<nums1.length;i++)
        {
            ans[i]=ref[hm.get(nums1[i])];
        }
        return ans;
    }
}