class Solution {
    public int minPathSum(int[][] cost) {
        int row=cost.length;
        int col=cost[0].length;
       for (int i=1 ; i<row ; i++){ 
        cost[i][0] += cost[i-1][0]; 
    } 
  
    // for 1st row 
    for (int j=1 ; j<col ; j++){ 
        cost[0][j] += cost[0][j-1]; 
    } 
  
    // for rest of the 2d matrix 
    for (int i=1 ; i<row ; i++) { 
        for (int j=1 ; j<col ; j++) { 
            cost[i][j] +=  Math.min(cost[i-1][j], cost[i][j-1]); 
        } 
    } 
  
    // returning the value in last cell 
    return cost[row-1][col-1]; 
    }
  
}