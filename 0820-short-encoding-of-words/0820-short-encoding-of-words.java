class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(String word:words){
            if(sb.indexOf(word+"#")==-1)
            {
                sb.append(word+"#");
            }
        }
        return sb.length();
    }
}