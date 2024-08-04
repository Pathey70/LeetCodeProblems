class Solution {
    public int nextGreaterElement(int n) {
        String str=Integer.toString(n);
        char arr[]=str.toCharArray();
        boolean done=false;
        for(int i=str.length()-1;i>=0;i--)
        {
            if(done)
                break;
            for(int j=arr.length-1;j>i;j--)
            {
                if(arr[i]<arr[j])
                {
                    done=true;
                    char c=arr[i];
                    arr[i]=arr[j];
                    arr[j]=c;
                    int k=i+1;
                    int l=arr.length-1;
                    while(k<l)
                    {
                        c=arr[k];
                        arr[k]=arr[l];
                        arr[l]=c;
                        k++;
                        l--;
                    }
                    break;
                }
            }
        }
        String str1=new String(arr);
        try{
        return done ? Integer.parseInt(str1) : -1;
        }
        catch(Exception e){
            return -1;
        }
    
    }
}