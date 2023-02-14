class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int start=(int)Math.ceil((-1+Math.sqrt(1+8.0*target))/2);
        while((sumN(start)-target)%2!=0){
            start++;
        }
        return start;
    }
    public int sumN(int n){
        return ((n)*(n+1))/2;
    }
   
}