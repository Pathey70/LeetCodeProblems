class Solution {
    public long minimumPerimeter(long neededApples) {
        long count=0;
        while(neededApples>0){
            neededApples-=countAppleOnRadius(++count);
        }
        return count*8;
    }
    public long countAppleOnRadius(long r){
        return 4*(r*(2*r+1)+(r)*(r+1))-8*r;
    }
}