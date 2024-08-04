class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);
        Stack<List<Integer>> stack=new Stack<List<Integer>>();
       /* List<Integer> start=new ArrayList<Integer>();
        start.add(nums[0]);
        start.add(0);
        stack.add(start);*/
        for(int i=0;i<2*n;i++)
        {
            int idx=i%n;
            int p=nums[idx];
            while(!stack.isEmpty()&&stack.peek().get(0)<p)
            {
                List<Integer> elem=stack.pop();
                ans[elem.get(1)]=p;
            }
            List<Integer> li=new ArrayList<>();
            li.add(p);
            li.add(idx);
            stack.push(li);
        }
        
        return ans;
    }
}