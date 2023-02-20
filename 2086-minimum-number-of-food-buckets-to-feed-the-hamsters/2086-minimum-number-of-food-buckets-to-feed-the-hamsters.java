class Solution {
    public int minimumBuckets(String hamsters) {
        int i=0;
        int lb=-2;
        int count=0;
        while(i<hamsters.length()){
            char c=hamsters.charAt(i);
            if(c=='H'&&lb!=i-1){
                if(i+1<hamsters.length()&&hamsters.charAt(i+1)=='.')
                {
                    lb=i+1;
                    count++;
                }
                else if(i-1>=0&&hamsters.charAt(i-1)=='.'){
                    lb=i-1;
                    count++;
                }
                else{
                    return -1;
                }
            }
            
            i++;
        }
        return count;
    }
}