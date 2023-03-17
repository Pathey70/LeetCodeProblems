class Node
{
    HashMap<Character,Node> children;
    char id;
    boolean end;
    Node(char id)
    {
        this.id=id;
        children=new HashMap<Character,Node>();
        end=false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node('|');
    }
    
    public void insert(String word) {
        Node rootLocal=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(!rootLocal.children.containsKey(c))
            {
                 Node node=new Node(c);
                rootLocal.children.put(c,node);
            }
            rootLocal=rootLocal.children.get(c);
            if(i==word.length()-1)
            {
                rootLocal.end=true;
            }
           
        }

    }
    
    public boolean search(String word) {
        Node rootLocal=root;
        //System.out.println(root.children.get('a'));
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(!rootLocal.children.containsKey(c))
            {
                return false;
            }
            rootLocal=rootLocal.children.get(c);
            if(i==word.length()-1)
            {
                if(!rootLocal.end)
                    return false;
            }
        }
        return true;
    }
    
    public boolean startsWith(String word) {
         Node rootLocal=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(!rootLocal.children.containsKey(c))
                return false;
            rootLocal=rootLocal.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */