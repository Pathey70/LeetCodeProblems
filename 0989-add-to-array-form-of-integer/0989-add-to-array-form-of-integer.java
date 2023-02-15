class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans= new ArrayList<Integer>();
        int prevCarry=0;
        for(int i=num.length-1;i>=0;i--)
        {
            if(k!=0)
            {
                int n1=num[i];
                int n2=(k%10);
                k=k/10;
                int sum=(n1+n2+prevCarry);
                prevCarry=sum/10;
                ans.add(sum%10);
            }
            else
            {
                int sum=(num[i]+prevCarry);
                prevCarry=sum/10;
                ans.add(sum%10);
            }
            
        }
        while(k!=0)
        {
            int sum=(prevCarry+k%10);
            k=k/10;
            prevCarry=sum/10;
            ans.add(sum%10);
        }
        if(prevCarry==1)
        {
            ans.add(1);
        }
        List<Integer> ans1=new ArrayList<Integer>();
        for(int i=ans.size()-1;i>=0;i--)
        {
            ans1.add(ans.get(i));
        }
        return ans1;
    }
}