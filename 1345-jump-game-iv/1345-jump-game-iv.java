class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        for(int i=0;i<n-1;i++)
            dp[i]=Integer.MAX_VALUE-1;
        boolean flag=true;
        HashMap<Integer,Integer> right=new HashMap<>();
        right.put(arr[n-1],0);
        int j=0;
        while(j<8){
            flag=false;
            for(int i=n-2;i>=0;i--){
                int min=dp[i+1]+1;
                min=Math.min(min,i>0 ? dp[i-1]+1 : Integer.MAX_VALUE);
                min=Math.min(min,right.getOrDefault(arr[i],Integer.MAX_VALUE-1)+1);
                if(min<dp[i])
                {   
                    dp[i]=min;
                    flag=true;
                    right.put(arr[i],Math.min(dp[i],right.getOrDefault(arr[i],Integer.MAX_VALUE)));
                }
            }
            j++;
        }
        return dp[0];
    }
}