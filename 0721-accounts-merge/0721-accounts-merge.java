class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        int parent[]=new int[n];
        int rank[]=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> li=accounts.get(i);
            for(int j=1;j<li.size();j++)
            {
                String email=li.get(j);
                if(hm.containsKey(email))
                {
                    union(parent,i,hm.get(email),rank);
                }else{
                    hm.put(email,i);
                }
            }
        }
        List<List<String>> ans=new ArrayList<List<String>>();
        List<String> temp=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(Map.Entry<String,Integer> entry:hm.entrySet())
        {
            String s1=entry.getKey();
            int value=entry.getValue();
            int p1=findParent(parent,value);
            List<String> li;
            if(map.containsKey(p1))
            {
                li=ans.get(map.get(p1));
            }
            else{
                li=new ArrayList<>();
                map.put(p1,ans.size());
                temp.add(accounts.get(p1).get(0));
                ans.add(li);
            }
            li.add(s1);
        }
        //System.out.println(ans);
        for(int i=0;i<ans.size();i++)
        {
            
            List<String> li=ans.get(i);
            Collections.sort(li);
            li.add(0,temp.get(i));
            //System.out.println(li);
        }
        return ans;
       
    }
    
    public void union(int parent[],int x1,int x2,int rank[])
    {
        int p1=findParent(parent,x1);
        int p2=findParent(parent,x2);
        if(p1==p2)
            return;
        if(rank[p1]>rank[p2])
        {
            rank[p1]+=rank[p2];
            parent[p2]=p1;
        }
        else{
            rank[p2]+=rank[p1];
            parent[p1]=p2;
        }
    }
    
    public int findParent(int parent[],int x)
    {
        if(parent[x]==x)
            return x;
        parent[x]=findParent(parent,parent[x]);
        return parent[x];
    }
}