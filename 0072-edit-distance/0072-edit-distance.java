class Solution {
    public int minDistance(String word1, String word2) {
        int e1=word1.length();
        int e2=word2.length();
        int dp[][]=new int[e1+1][e2+1];
        for(int i=0;i<e1+1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<e2+1;j++){
            dp[0][j]=j;
        }
        for(int i=0;i<e1;i++){
            for(int j=0;j<e2;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j];
                }
                else{
                    int min1=1+dp[i+1][j];
                    int min2=1+dp[i][j];
                    int min3=1+dp[i][j+1];
                    //int min3=Integer.MAX_VALUE;
                    /*int t2=i;
                    while(t2>=0&&word1.charAt(t2)!=word2.charAt(j)){
                        t2--;
                    }
                    if(t2>=0){
                        min3=i-t2+dp[t2][j];
                    }*/
                    int min=Math.min(min1,Math.min(min2,min3));
                    dp[i+1][j+1]=min;
                }
            }
        }
        
        return dp[e1][e2];
        //return distance(word1,word2,end1-1,end2-1);
    }
    public int distance(String s1,String s2,int e1,int e2){
        if(e1<0){
            return e2+1;
        }
        else if(e2<0){
            return e1+1;
        }
        else if(s1.charAt(e1)==s2.charAt(e2)){
            return distance(s1,s2,e1-1,e2-1);
        }
        else{
            char c=s2.charAt(e2);
            int min1=1+distance(s1,s2,e1,e2-1);
            int min3=1+distance(s1,s2,e1-1,e2-1);
            int e11=e1;
            while(e1>=0&&s1.charAt(e1)!=c){
                e1--;
            }
            int min2=Integer.MAX_VALUE;
           
            if(e1>=0){
                min2=e11-e1+distance(s1,s2,e1-1,e2-1);
            }
            //System.out.println(min1+" "+min2+" "+e2);
            return Math.min(min1,Math.min(min2,min3));
           
        }
    }
}