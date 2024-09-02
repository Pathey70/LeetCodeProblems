class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total=0;
        for(int i=0;i<chalk.length;i++)
            total+=chalk[i];
        long k1=k%total;
        for(int i=0;i<chalk.length;i++)
        {
            k1-=chalk[i];
            if(k1<0)
                return i;
        }
        
        return -1;
        
    }
}