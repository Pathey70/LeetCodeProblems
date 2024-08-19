class Solution {
    public int minSteps(int n) {
        if(n==1)
            return 0;
        int t=( int) Math.sqrt(n);
        System.out.println(n);
        for(int i=2;i<=t;i++)
        {
            if(n%i==0)
            {
                return i+minSteps((int)n/i);
            }
        }
        return n;
        
        
    }
}