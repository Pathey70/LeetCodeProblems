class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='a')
                count++;
        }
        int aCount=0;
        int bCount=0;
        int min=count;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='a')
                aCount++;
            else
                bCount++;
            min=Math.min(min,count-aCount+bCount);
        }
        return min;
    }
}