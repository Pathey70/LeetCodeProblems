class Solution {
   
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int combined[][]=new int[n][3];
        for(int i=0;i<n;i++){
            combined[i][0]=scores[i];
            combined[i][1]=ages[i];
        }
        Arrays.sort(combined,(x,y)->{
            if(x[1]==y[1]){
                return x[0]-y[0];
            }
            return x[1]-y[1];
        });
        combined[0][2]=combined[0][0];
        int ans=combined[0][0];
        for(int i=1;i<n;i++){
            int max=combined[i][0];
            for(int j=0;j<i;j++){
                if(combined[i][0]>=combined[j][0]){
                    max=Math.max(max,combined[j][2]+combined[i][0]);
                }
            }
            combined[i][2]=max;
            ans=Math.max(ans,max);
        }
        return ans;
    }
    /*public void rec(int arr[][],int index,int score,int localMax){
        if(index==arr.length){
            max=Math.max(max,score);
            return;
        }
        int element=arr[index][0];
        if(element<localMax){
            rec(arr,index+1,score,localMax);
        }
        else{
            rec(arr,index+1,score+element,element);
            rec(arr,index+1,score,localMax);
        }
    }*/
}