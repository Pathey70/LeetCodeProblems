class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int rightOnes[][]=new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            if(matrix[i][m-1]=='1')
                rightOnes[i][m-1]=1;
            for(int j=m-2;j>=0;j--)
            {
                if(matrix[i][j]=='1')
                    rightOnes[i][j]+=rightOnes[i][j+1]+1;
            }
        }
        
        int max=0;
        for(int j=0;j<m;j++)
        {
            Stack<Integer> stack=new Stack<Integer>();
            stack.push(-1);
            
            for(int i=0;i<n;i++)
            {
                int p=rightOnes[i][j];
                //System.out.println(stack);
                while(stack.peek()!=-1&&rightOnes[stack.peek()][j]>=p)
                {
                    int p1=stack.pop();
                    int h=rightOnes[p1][j];
                    max=Math.max(max,h*(i-stack.peek()-1));
                }
                stack.push(i);
            }
            while(stack.peek()!=-1)
            {
                int p1=stack.pop();
                int h=rightOnes[p1][j];
                max=Math.max(max,h*(n-stack.peek()-1));
            }
          
        }
        return max;
    }
}