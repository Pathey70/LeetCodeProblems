class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cons=1;
        int possible=0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                possible+=calculate(cons);
                cons=0;
            }
            else{
                cons++;
            }
        }
        possible+=calculate(cons+1);
        return possible>=n ? true:false;
    }
    public int calculate(int n){
        return Math.max((n-1)/2,0);
    }
}