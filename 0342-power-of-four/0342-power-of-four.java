class Solution {
    public boolean isPowerOfFour(int n) {
        /*if(n==1)
            return true;
        if(n%4!=0||n==0)
            return false;
        else
            return isPowerOfFour(n/4);*/
        return isPower(1,n);
    }
    
    public boolean isPower(long i,int n){
        if(i==n)
            return true;
        if(i>n)
            return false;
        return isPower(i*4,n);
    }
}