class Solution {
    int mod=1000000007;
    public int numPrimeArrangements(int n) {
        int count=0;
        for(int i=2;i<=n;i++){
            if(isPrime(i))
                count++;
        }
        long ans=fact(count)*fact(n-count);
        return (int) (ans%mod);
    }
    public long fact(int n){
        long ans=1;
        for(int i=2;i<=n;i++){
            ans*=i;
            ans%=mod;
        }
        return ans;
    }
    public boolean isPrime(int n){
        //boolean ans=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}