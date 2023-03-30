class FileSystem {
    Directory root;
    public FileSystem() {
        root=new Directory("");
    }
    
    public boolean createPath(String path, int value) {
        String arr[]=pathSplitter(path);
        Directory node=root;
        for(int i=1;i<arr.length-1;i++){
            node=node.getChildren(arr[i]);
            if(node==null)
                return false;
        }
        if(node.getChildren(arr[arr.length-1])==null){
            Directory child=new Directory(arr[arr.length-1]);
            child.setValue(value);
            node.addChildren(arr[arr.length-1],child);
            return true;
        }
        else{
            return false;
        }
    }
    
    public int get(String path) {
        String arr[]=pathSplitter(path);
        Directory node=root;
        for(int i=1;i<arr.length;i++){
            node=node.getChildren(arr[i]);
            if(node==null)
                return -1;
        }
        return node.getValue();
    }
    public String[] pathSplitter(String path){
        return path.split("/");
    }
}
class Directory{
    HashMap<String,Directory> children;
    String name;
    private int val;
    Directory(String name){
        this.name=name;
        children=new HashMap<>();
        val=-1;
    }
    public void setValue(int val){
        this.val=val;
    }
    public int getValue(){
        return val;
    }
    public Directory getChildren(String child){
        return children.get(child);
    }
    public void addChildren(String child,Directory childDir){
        children.put(child,childDir);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */