class Solution {
    public int compress(char[] chars) {
        int right=1;
        int left=0;
        int prevLen=1;
        char prevChar=chars[left];
        while(right<chars.length){
            if(chars[right]!=prevChar)
            {
                chars[left++]=prevChar;
                prevChar=chars[right];
                left=addLen(chars,prevLen,left);
                prevLen=0;
            }
            prevLen++;
            right++;
        }
        chars[left++]=prevChar;
        left=addLen(chars,prevLen,left);
        return left;
    }
    public int addLen(char chars[],int prevLen,int left){
        if(prevLen>1){
            String str=Integer.toString(prevLen);
            char arr[]=str.toCharArray();
            for(int j=0;j<arr.length;j++){
                        chars[left++]=arr[j];
            }
        }
        return left;
    }
}