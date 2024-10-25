class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        List<String> ans=new ArrayList<>();
        Node root=new Node();
        for(String s:folder)
        {
            String arr[]=s.split("/");
            Node rootCp=root;
            for(int i=1;i<arr.length;i++)
            {
                if(!rootCp.children.containsKey(arr[i]))
                {
                    Node node=new Node();
                    rootCp.children.put(arr[i],node);
                }
                rootCp=rootCp.children.get(arr[i]);
            }
            rootCp.end=true;
        }
        StringBuilder sb=new StringBuilder();
        dfs(root,ans,sb);
        return ans;
    }
    public void dfs(Node node,List<String> ans,StringBuilder sb)
    {
        if(node.end)
        {
            ans.add(sb.toString());
            return;
        }
        for(Map.Entry<String,Node> entry:node.children.entrySet())
        {
            String key=entry.getKey();
            Node value=entry.getValue();
            StringBuilder s1=new StringBuilder(sb);
            s1.append("/");
            s1.append(key);
            dfs(value,ans,s1);
        }
    }
}

class Node{
    boolean end;
    HashMap<String,Node> children;
    Node(){
        end=false;
        children=new HashMap<>();
    }
}