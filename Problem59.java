
/*
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n*n in spiral order.

 



 * */
public class Problem59 {
	 public int[][] generateMatrix(int n) {
	        int[][] spiral=new int[n][n];
	        int n1=n;
	        int count=1;
	        int l1=0;
	        int l2=n;
	        int r1=1;
	        int r2=n-1;
	        int s=0;
	        while(n1>1)
	        {
	            for(int i=l1;i<l2;i++)
	            {
	                spiral[s][i]=count;
	                count++;
	            }
	            for(int i=r1;i<r2;i++)
	            {
	                spiral[i][n-s-1]=count;
	                count++;
	            }
	            for(int i=l2-1;i>=l1;i--)
	            {
	                spiral[n-s-1][i]=count;
	                count++;
	            }
	            for(int i=r2-1;i>=r1;i--)
	            {
	                spiral[i][s]=count;
	                count++;
	            }
	            n1=n1-2;
	            s++;
	            l1++;
	            l2--;
	            r1++;
	            r2--;
	        }
	        if(n%2!=0)
	        spiral[n/2][n/2]=n*n;
	        return spiral;
	    }
}
