class Solution {
    public String rearrangeString(String s, int k) {
        if(k==0)
            return s;
        int lengthRequired=0;
        int freq[]=new int[26];
        int maxFreq=0;
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(i)-'a']);
        }
        lengthRequired=(maxFreq-1)*k;
        for(int i=0;i<26;i++)
        {
            if(freq[i]==maxFreq)
                lengthRequired++;
        }
        if(lengthRequired>s.length())
            return "";
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int a[],int b[])
            {
                if(a[0]!=b[0])
                    return b[0]-a[0];
                else
                    return b[1]-a[1];
            }
        });
        for(int i=0;i<26;i++)
        {
            if(freq[i]!=0)
            {
                int pair[]={freq[i],i};
                pq.add(pair);
            }
        }
        int j=0;
        StringBuilder ans=new StringBuilder();
        int temp[][]=new int[k][2];
        while(j<s.length())
        {
            int i=0;
            while(i<k&&j<s.length())
            {
                int p1[]=pq.poll(); 
                ans.append((char)('a'+p1[1]));
                //System.out.println(ans+" "+p1[0]+" "+p1[1]);
                p1[0]--;
                temp[i]=p1;
                i++;
                j++;
            }
            for(i=0;i<k;i++)
            {
                if(temp[i][0]!=0)
                    pq.add(temp[i]);
            }
        }
        return ans.toString();
    }
}