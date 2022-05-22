public class Problem647 {
    public int countSubstrings(String s) {
        int dp[][]=new int[s.length()][s.length()];
        int count=0;
       for(int i=s.length()-1;i>=0;i--)
       {
           for(int j=i;j<s.length();j++)
           {
               if(i==j)
               {
                   count++;
                   dp[i][j]=1;
               }
               else if(s.charAt(i)==s.charAt(j))
               {
                   if(dp[i+1][j-1]!=0||j==i+1)
                   {   
                       count++;
                       dp[i][j]=2+dp[i+1][j-1];
                   }

               }
               else
               {
                   dp[i][j]=0;
               }
           }
       }
       //return dp[0][s.length()-1];
        return count;
    }
}