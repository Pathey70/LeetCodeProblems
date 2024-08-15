class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBills=0;
        int tenBills=0;
        for(int i:bills)
        {
            if(i==5)
                fiveBills++;
            else if(i==10)
            {
                if(fiveBills>0)
                    fiveBills--;
                else
                    return false;
                tenBills++;
            }
            else{
                if(tenBills>0&&fiveBills>0)
                {
                    tenBills--;
                    fiveBills--;
                }
                else if(fiveBills>=3)
                {
                    fiveBills-=3;
                }
                else
                    return false;
            }
        }
        return true;
    }
}