class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int e1=0;
        int e0=0;
        int zero=0;
        int mod=1000000007;
        for(int i=0;i<binary.length();i++)
        {
            if(binary.charAt(i)=='1')
            {
                e1=(e1+e0+1)%mod;
            }else{
                zero=1;
                e0=(e1+e0)%mod;
            }
        }
        return (e1+e0+zero)%mod;
    }
}