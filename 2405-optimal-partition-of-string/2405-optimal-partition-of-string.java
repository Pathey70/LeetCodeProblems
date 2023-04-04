class Solution {
    public int partitionString(String s) {
        int count=1;
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hs.contains(c)){
                hs=new HashSet<>();
                count++;
            }
            hs.add(c);
        }
        return count;
    }
}