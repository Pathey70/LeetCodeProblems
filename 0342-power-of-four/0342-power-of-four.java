class Solution {
    public boolean isPowerOfFour(int n) {
        if(Integer.toBinaryString(n).lastIndexOf("1")==0&&Integer.toBinaryString(n).length()%2!=0)
            return true;
        return false;
    }
    
  
}