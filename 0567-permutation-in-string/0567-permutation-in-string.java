class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int arr1[]=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            char c=s1.charAt(i);
            int c1=(int )c-97;
            arr1[c1]++;
        }
        int arr2[]=new int[26];
        for(int i=0;i<s2.length();i++)
        {
            char c=s2.charAt(i);
            int c1=(int )c-97;
            arr2[c1]++;
            if(i>=s1.length())
            {
                char c2=s2.charAt(i-s1.length());
                int c3=(int )c2-97;
                arr2[c3]--;
            }
            boolean flag=true;
            for(int j=0;j<26;j++)
            {
                if(arr1[j]!=arr2[j])
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }
}