class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left=0;
        int right=0;
        int max=0;
        int tCount=0;
        int fCount=0;
        while(right<answerKey.length()){
            char c=answerKey.charAt(right);
            if(c=='T')
                tCount++;
            else
                fCount++;
            if(Math.min(tCount,fCount)>k){
                char c1=answerKey.charAt(left);
                if(c1=='T')
                    tCount--;
                else
                    fCount--;
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}