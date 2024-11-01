class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length())
        {
            int n=sb.length();
            char c=s.charAt(i);
            if(n<2||sb.charAt(n-1)!=c||sb.charAt(n-2)!=c)
                sb.append(c);
            i++;
        }
        return sb.toString();
    }
}