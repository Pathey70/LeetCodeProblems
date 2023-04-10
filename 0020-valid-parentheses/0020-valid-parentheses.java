class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='}'){
                if(!stack.isEmpty()){
                    char c1=stack.pop();
                    if(c1!='{')
                        return false;
                }
                else
                    return false;
            }
            else if(c==']'){
                 if(!stack.isEmpty()){
                    char c1=stack.pop();
                    if(c1!='[')
                        return false;
                }
                else
                    return false;
            }
            else if(c==')'){
                 if(!stack.isEmpty()){
                    char c1=stack.pop();
                    if(c1!='(')
                        return false;
                }
                else
                    return false;
            }
            else{
                stack.push(c);
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}