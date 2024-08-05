class Solution {
    public String countOfAtoms(String formula) {
        HashMap<Integer,Integer> paranthesisMap=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<formula.length();i++)
        {
            if(formula.charAt(i)=='(')
                stack.push(i);
            else if(formula.charAt(i)==')')
                paranthesisMap.put(stack.pop(),i);
        }
        TreeMap<String,Integer> freqMap=solve(formula,paranthesisMap,0,formula.length());
        StringBuilder ans=new StringBuilder();
        for(Map.Entry<String,Integer> entry:freqMap.entrySet())
        {
            String s=entry.getKey();
            Integer value=entry.getValue();
            ans.append(s);
            if(value>1)
                ans.append(value.toString());
        }
        return ans.toString();
    }
    
    public  TreeMap<String,Integer> solve(String formula,HashMap<Integer,Integer> paranthesisMap,int begin,int end)
    {
        TreeMap<String,Integer> freqMap=new TreeMap<>();

        int i=begin;
        while(i<end)
        {
            char c=formula.charAt(i);
            if(c=='(')
            {
                TreeMap<String,Integer> subTree=solve(formula,paranthesisMap,i+1,paranthesisMap.get(i));
                i=paranthesisMap.get(i)+1;
                int freq=0;
                while(i<end&&Character.isDigit(formula.charAt(i)))
                {
                    freq*=10;
                    freq+=(int)(formula.charAt(i))-48;
                    i++;
                }
                freq=Math.max(freq,1);
                for(Map.Entry<String,Integer> entry:subTree.entrySet())
                {
                    String key=entry.getKey();
                    int value=entry.getValue();
                    freqMap.put(key,freqMap.getOrDefault(key,0)+value*freq);
                }
            }
            else if(Character.isUpperCase(c))
            {
                StringBuilder sb=new StringBuilder();
                sb.append(c);
                i++;
                while(i<end&&Character.isLowerCase(formula.charAt(i)))
                {
                    sb.append(formula.charAt(i));
                    i++;
                }
                int freq=0;
                while(i<end&&Character.isDigit(formula.charAt(i)))
                {
                    freq*=10;
                    freq+=(int)(formula.charAt(i))-48;
                    i++;
                }
                freqMap.put(sb.toString(),freqMap.getOrDefault(sb.toString(),0)+Math.max(1,freq));
            }
        }
        
        return freqMap;
    }
}