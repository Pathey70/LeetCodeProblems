class Solution {
    public int largestCombination(int[] candidates) {
        int arr[]=new int[25];
        for(int i=0;i<candidates.length;i++)
        {
            int count=0;
            while(candidates[i]!=0)
            {
                int mod=candidates[i]%2;
                if(mod!=0)
                {
                    arr[count]++;
                }
                count++;
                candidates[i]=candidates[i]/2;
            }
        }
        int max=0;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}