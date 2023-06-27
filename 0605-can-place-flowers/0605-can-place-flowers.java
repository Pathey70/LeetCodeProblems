class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*int count=0;
        int gap=0;
        //int count=0;
        int start=0;
        int end=flowerbed.length-1;
        if(flowerbed.length==1&&flowerbed[0]==0&&n==1)
        {
            return true;
        }
        while(true)
        {
            if(start==flowerbed.length-1||flowerbed[start]==1)
            {
                break;
            }
            start++;
        }
        while(true)
        {
            if(end==0||flowerbed[end]==1)
            {
                break;
            }
            end--;
        }
        for(int i=start+1;i<end;i++)
        {
            if(flowerbed[i]==1)
            {
                if(gap!=0)
                count+=(gap-1)/2;
                gap=0;
            }
            else
            {
                gap++;
            }
        }
        if(gap!=0)
        count+=(gap-1)/2;
        if(start<=end)
        {
            int total=start/2+(flowerbed.length-end-1)/2+count;
            System.out.println(start+" "+end+" "+count);
            if(total>=n)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if((flowerbed.length+1)/2>=n)
            {
                return true;
            }
            else
            {
                return false;
            }
        }*/
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