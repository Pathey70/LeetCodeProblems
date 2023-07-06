class Solution {
    public String decodeString(String s) {
        Stack<Character> stack=new Stack<>();
        Stack<Integer> numberStack=new Stack<>();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(isNumber(c)){
                num*=10;
                num+=((int)c-48);
            }else if(c=='['){
                stack.push(c);
                numberStack.push(num);
                num=0;
            }
            else if(c==']'){
                List<Character> tempList=new ArrayList<>();
                while(stack.peek()!='['){
                    tempList.add(stack.pop());
                }
                stack.pop();
                int k=numberStack.pop();
                for(int j=0;j<k;j++){
                    for(int k1=tempList.size()-1;k1>=0;k1--){
                        char r=tempList.get(k1);
                        stack.push(r);
                    }
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
    public boolean isNumber(char c){
        if((int)c>=48&&(int)c<=57)
            return true;
        else
            return false;
    }
}