class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        double o=-1;
        long n1=(long)Math.ceil(( o+Math.sqrt(1+8.0*target))/2);
        while((sumN(n1)-target)%2!=0){
            n1++;
        }
        return (int)n1;
    }
    public long sumN(long n){
        return ((n)*(n+1))/2;
    }
   
}