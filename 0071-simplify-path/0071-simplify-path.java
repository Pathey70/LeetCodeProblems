class Solution {
    public String simplifyPath(String path) {
        Stack<String> dicts=new Stack<>();
        int i=1;
        int prev=0;
        while(i<path.length()){
            char c=path.charAt(i);
            if(c=='/'){
                String s=path.substring(prev+1,i);
                stackOps(s,dicts);
                prev=i;
            }
            i++;
        }
        if(prev!=path.length()){
            String s=path.substring(prev+1);
            stackOps(s,dicts);
        }
        StringBuilder sb=new StringBuilder();
        while(!dicts.isEmpty()){
            StringBuilder s=new StringBuilder(dicts.pop());
            sb.append(s.reverse()+"/");
        }
        return sb.length()==0? "/" : sb.reverse().toString();
    }
    public void stackOps(String s,Stack<String> dicts){
        if(s.equals(".")||s.length()==0){
                    //No ops
        }
        else if(s.equals("..")){
            if(!dicts.isEmpty())
                dicts.pop();
        }
        else{
            dicts.push(s);
        }
    }
}