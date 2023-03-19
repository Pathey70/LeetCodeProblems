class WordDictionary {

    TreeNode root;
    public WordDictionary() {
        root=new TreeNode();
    }
    
    public void addWord(String word) {
        TreeNode root1=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(root1.children.containsKey(c))
            {
                root1=root1.children.get(c);
            }
            else{
                TreeNode node=new TreeNode();
                root1.children.put(c,node);
                root1=node;
            }
        }
        root1.end=true;
    }
    
    public boolean search(String word) {
        return searchHelp(word,root,0);
    }
    public boolean searchHelp(String word,TreeNode node,int index){
        
        if(index==word.length())
        {
           // System.out.println(node.end);
            if(node.end)
                return true;
            else
                return false;
        }
        else if(word.charAt(index)=='.'){
            boolean flag=false;
            for(Map.Entry<Character,TreeNode> mp:node.children.entrySet()){
                flag=flag||searchHelp(word,mp.getValue(),index+1);
            }
            return flag;
        }
        else{
            if(node.children.containsKey(word.charAt(index)))
            {
                return searchHelp(word,node.children.get(word.charAt(index)),index+1);
            }
            else{
                return false;
            }
        }
    }
    
}
class TreeNode{
    //char c;
    HashMap<Character,TreeNode> children;
    boolean end;
   
    TreeNode()
    {
        children=new HashMap<>();
        end=false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */