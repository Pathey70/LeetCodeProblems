class Solution {
    public long minimumSteps(String s) {
        long ans=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
                count++;
        }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1'&&i<count)
            {
                ans+=(count-i);
                count++;
            }
            
        }
        return ans;
    }
}