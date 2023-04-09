class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int g=numsDivide[0];
        for(int i=1;i<numsDivide.length;i++){
            g=gcd(g,numsDivide[i]);
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(g%nums[i]==0)
                return i;
        }
        return -1;
    }
    public int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }
     
}