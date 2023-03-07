class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min=1;
        long max=min*time[0]*totalTrips;
        long ans=-1;
        while(min<=max){
            long mid=min+(max-min)/2;
            long t=0;
            for(int i=0;i<time.length;i++){
                t+=(mid/time[i]);
            }
            if(t>=totalTrips){
                ans=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
            //System.out.println(mid+" "+ans);
        }
        //System.out.println(ans);
        return ans;
    }
}