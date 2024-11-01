class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length())
        {
            if(sb.length()>=2&&s.charAt(i)==sb.charAt(sb.length()-1)&&s.charAt(i)==sb.charAt(sb.length()-2))
            {
                
            }else{
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}