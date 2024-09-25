class Solution {
    int count=0;
    public int[] sumPrefixScores(String[] words) {
        int n=words.length;
        int ans[]=new int[n];
        Trie root=new Trie();
        //HashMap<Integer,Trie> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String s=words[i];
            Trie node=root;
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                if(node.children.containsKey(c)){
                    node=node.children.get(c);
                }
                else{
                    Trie node1=new Trie();
                    node1.c=c;
                    node.children.put(c,node1);
                    node=node1;
                }
            }
            if(node.id!=-1)
            {
                //node.id=i;
                node.val+=1;
            }  
            else{
                node.id=i;
                node.val=1;
            }
           // hm.put(i,node);
        }
        dfs(root);
        for(int i=0;i<words.length;i++){
            int total=0;
              String s=words[i];
            Trie node=root;
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                node=node.children.get(c);
                //System.out.println(node.val+" "+c);
                total+=node.val;
            }
            ans[i]=total;
        }
        return ans;
    
    }
    public int dfs(Trie node){
        int c1=node.val;
        for(Map.Entry<Character,Trie> entry:node.children.entrySet()){
            
            c1+=dfs(entry.getValue());
        }
        node.val=c1;
        return c1;
    }
}

class Trie{
    char c;
    int id=-1;
    HashMap<Character,Trie> children;
    int val=0;
    Trie(){
        children=new HashMap<>();
    }
}