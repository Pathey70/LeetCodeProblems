class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int intervalsI[][]=new int[n][3];
        for(int i=0;i<n;i++){
            intervalsI[i][0]=intervals[i][0];
            intervalsI[i][1]=intervals[i][1];
            intervalsI[i][2]=i;
        }
        Arrays.sort(intervalsI,(a,b)->a[0]-b[0]);
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int key=intervalsI[i][1];
            int start=i;
            int end=n-1;
            int index=-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(intervalsI[mid][0]>=key){
                    index=mid;
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            if(index!=-1)
                ans[intervalsI[i][2]]=intervalsI[index][2];
            else
                ans[intervalsI[i][2]]=-1;
        }
        return ans;
    }
}