/*class Solution {
    public int findTheLongestSubstring(String s) {
        int n=s.length();
        int freq[][]=new int[n+1][5];
        for(int i=0;i<n;i++)
        {
            int j=idx(s.charAt(i));
            freq[i+1]=freq[i];
            if(j!=-1)
                freq[i+1][j]++;
            for(j=0;j<5;j++)
                System.out.print(freq[i+1][j]+" ");
            System.out.println();
        }
        int left=0;
        int right=0;
        int cf[]=new int[5];
        int max=0;
        while(right<n)
        {
            int j=idx(s.charAt(right));
            if(j!=-1)
            {
                cf[j]++;
                
                if(cf[j]%2!=0&&freq[n][j]-freq[right][j]==1)
                {
                    System.out.println("In loop");
                    while(idx(s.charAt(left))!=j)
                    {
                        int c=idx(s.charAt(left));
                        if(c!=-1)
                            cf[c]--;
                        left++;
                    }
                    cf[j]--;
                    left++;
                    
                }
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
    public int idx(char c)
    {
        switch(c)
        {
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i' :
                return 2;
            case  'o' :
                return 3;
            case  'u' :
                return 4;
            default:
                return -1;
        }
    }
}*/
class Solution {

    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];
        for (int i = 0; i < 32; i++) mp[i] = -1;
        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= characterMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - mp[prefixXOR]);
        }
        return longestSubstring;
    }
}
