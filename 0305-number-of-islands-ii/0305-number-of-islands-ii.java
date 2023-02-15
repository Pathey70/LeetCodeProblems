class Solution {
    HashMap<String,String> hm;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> li=new ArrayList<>();
        li.add(1);
        hm=new HashMap<>();
        String initial=Integer.toString(positions[0][0])+" "+Integer.toString(positions[0][1]);
        
        hm.put(initial,initial);
       // System.out.println(initial+" "+hm.get(initial));
        for(int i=1;i<positions.length;i++)
        {
            
            String s1=Integer.toString(positions[i][0])+" "+Integer.toString(positions[i][1]);
            if(hm.containsKey(s1))
            {
                li.add(li.get(i-1));
                continue;
            }
            String arr[]=generate(positions[i][0],positions[i][1]);
            HashSet<String> hs=new HashSet<>();
            boolean flags[]=new boolean[arr.length];
            for(int j=0;j<arr.length;j++)
            {
               // System.out.println(arr[j]);
                if(hm.containsKey(arr[j]))
                {
                    //System.out.println("Found");
                     String s=arr[j];
                     String parent=findParent(s);
                    if(hs.contains(parent)){
                        
                    }else{
                        flags[j]=true;
                        hs.add(parent);
                    }
                }
                
            }
            int count=0;
            hm.put(s1,s1);
            for(int j=0;j<arr.length;j++)
            {
                if(flags[j]){
                    union(s1,arr[j]);
                    count++;
                }
            }    
           // System.out.println(count);
            li.add(li.get(i-1)-count+1);
        }
        return li;
        
    }
    public String[] generate(int x,int y)
    {
        String arr[]=new String[4];
        arr[0]=Integer.toString(x+1)+" "+Integer.toString(y);
        arr[1]=Integer.toString(x)+" "+Integer.toString(y+1);
        arr[2]=Integer.toString(x-1)+" "+Integer.toString(y);
        arr[3]=Integer.toString(x)+" "+Integer.toString(y-1);
        return arr;
    }
    public void union(String s1,String s2)
    {
        String s1p=findParent(s1);
        String s2p=findParent(s2);
        hm.put(s2p,s1p);
    }
    public String findParent(String s){
      //  System.out.println(s+" fhdh");
        if(hm.get(s).equals(s))
        {
            return s;
        }
        else{
            hm.put(s,findParent(hm.get(s)));
            return hm.get(s);
        }
    }
}