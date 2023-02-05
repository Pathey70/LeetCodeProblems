class Solution {
    public int maxVowels(String s, int k) {
        int left=0;
        int right=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char cRight=s.charAt(i);
            if(isVowel(cRight)){
                right++;
            }
            if(i>=k){
                char cLeft=s.charAt(i-k);
                if(isVowel(cLeft))
                    left++;
            }
            ans=Math.max(ans,right-left);
        }
        return ans;
    }
    public boolean isVowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            return true;
        return false;
    }
}