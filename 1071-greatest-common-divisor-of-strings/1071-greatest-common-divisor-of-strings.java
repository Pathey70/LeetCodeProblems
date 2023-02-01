class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();
        String s1="";
        String s2="";
        if(n1<n2){
            s1=str1;
            s2=str2;
        }
        else{
            s1=str2;
            s2=str1;
        }
        String ans="";
        for(int i=s1.length();i>0;i--){
            if(n1%i==0&&n2%i==0){
                String sub=s1.substring(0,i);
                if(check(s1,sub)&&check(s2,sub)){
                    ans=sub;
                    break;
                }
            }
        }
        return ans;
    }
    public boolean check(String s2,String s1){
        int x1=s2.length()/s1.length();
        StringBuilder sb=new StringBuilder();
       
        for(int j=0;j<x1;j++){
            sb.append(s1);
        }
        return sb.toString().equals(s2);
    }
}