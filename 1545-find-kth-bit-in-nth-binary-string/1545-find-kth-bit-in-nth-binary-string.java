class Solution {
    public char findKthBit(int n, int k) {
        String s1="0";
        for(int i=0;i<n;i++)
        {
            s1=s1+"1"+flip(s1);
            //System.out.println(s1);
        }
        return s1.charAt(k-1);
    }
    public String flip(String s)
    {
        char arr[]=s.toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]=='1')
                arr[i]='0';
            else
                arr[i]='1';
        }
        StringBuilder ans=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
            ans.append(arr[i]);
        return ans.toString();
    }
}