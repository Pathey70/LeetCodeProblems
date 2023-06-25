class Solution {
    public int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            if(isPossible(Integer.toString(i*i),i))
            {
                ans+=(i*i);
            }
        }
        return ans;
    }
    
    public boolean isPossible(String s,int target){
        boolean ans=false;
        if(target<0)
            return ans;
        if(Integer.parseInt(s)==target){
            return true;
        }
        for(int i=0;i<s.length()-1;i++){
            String s1=s.substring(0,i+1);
            ans=ans||isPossible(s.substring(i+1),target-Integer.parseInt(s1));
        }
        return ans;
    }
}