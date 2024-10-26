class Solution {
    public String alienOrder(String[] words) {
        List<HashSet<Character>> graph=new ArrayList<>();
        List<HashSet<Character>> degree=new ArrayList<>();
        HashSet<Character> set=new HashSet<>();
        int totalChars=set.size();
        for(String word:words)
        {
            for(int i=0;i<word.length();i++)
                set.add(word.charAt(i));
        }
        if(set.size()==1)
            return words[0].substring(0,1);
        for(int i=0;i<26;i++)
        {
            HashSet<Character> li=new HashSet<>();
            graph.add(li);
            li=new HashSet<>();
            degree.add(li);
        }
        for(int i=1;i<words.length;i++)
        {
            String s1=words[i-1];
            String s2=words[i];
            int j=0;
            while(j<Math.min(s1.length(),s2.length())&&s1.charAt(j)==s2.charAt(j))
                j++;
            if(j<s1.length()&&j<s2.length())
            {
                char c1=s1.charAt(j);
                char c2=s2.charAt(j);
                graph.get(c1-'a').add(c2);
                degree.get(c2-'a').add(c1);
            }
            else if(j<s1.length())
                return "";
        }
        Queue<Character> queue=new LinkedList<>();
        int count=0;
        for(int i=0;i<26;i++)
        {
            if(graph.get(i).size()!=0&&degree.get(i).size()==0)
                queue.add((char)(i+'a'));
        }
        //System.out.println(queue);
        StringBuilder ans=new StringBuilder();
        while(!queue.isEmpty())
        {
            char c=queue.poll();
            ans.append(c);
            set.remove(c);
            HashSet<Character> nodes=graph.get(c-'a');
            for(Character c1:nodes)
            {
                HashSet<Character> hs=degree.get(c1-'a');
                hs.remove(c);
                if(hs.size()==0)
                    queue.add(c1);
            }
        }
        for(int i=0;i<26;i++)
        {
            if(degree.get(i).size()>0)
                return "";
        }
        for(Character c:set)
            ans.append(c);
        return ans.toString();
    }
}