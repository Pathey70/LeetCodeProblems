class Solution {
    long dp[][][];
    String piz[];
    int mod=1000000007;
    public int ways(String[] pizza, int k) {
        piz=pizza;
        dp=new long[pizza.length][pizza[0].length()][k+1];
        
        int a=(int )count(0,0,k);
        if(a==-1)
            return 0;
        return a;
    }
    public long count(int x,int y,int k)
    {
        if(x>=piz.length||y>=piz[0].length())
            return -1;
        if(dp[x][y][k]!=0)
            return dp[x][y][k];
        if(k==1)
        {
            for(int i=x;i<piz.length;i++)
            {
                for(int j=y;j<piz[i].length();j++)
                {
                    if(piz[i].charAt(j)=='A')
                    {
                        dp[x][y][k]=1;
                        return 1;
                    }
                }
            }
            dp[x][y][k]=-1;
            return -1;
        }
        boolean flag=false;
        long total=0;
        for(int i=x+1;i<piz.length;i++)
        {
            if(flag)
            {
                long t1=count(i,y,k-1);
                if(t1!=-1)
                    total=(total+t1)%mod;
            }
            else
            {
                for(int j=y;j<piz[i].length();j++)
                {
                    if(piz[i-1].charAt(j)=='A')
                    {
                        flag=true;
                        long t1=count(i,y,k-1);
                        if(t1!=-1)
                            total=(total+t1)%mod;
                        break;
                    }
                }
            }
        }
        flag=false;
        for(int j=y+1;j<piz[0].length();j++)
        {
            if(flag)
            {
                long t1=count(x,j,k-1);
                if(t1!=-1)
                    total=(total+t1)%mod;
            }
            else
            {
                for(int i=x;i<piz.length;i++)
                {
                    //System.out.println(i+" "+j);
                    if(piz[i].charAt(j-1)=='A')
                    {
                        flag=true;
                        long t1=count(x,j,k-1);
                        if(t1!=-1)
                            total=(total+t1)%mod;
                        break;
                    }
                }
            }
        }
        if(total==0)
        {
            dp[x][y][k]=-1;
            return -1;
        }
        dp[x][y][k]=total;
        return total;
        
        
    }
}