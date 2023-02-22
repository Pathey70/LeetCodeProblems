class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low=0;
        int high=10000001;
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(dist,mid,hour)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans==10000001 ? -1 : ans;
    }
    
    public boolean possible(int[] dist,int speed,double hour){
        double ans=0;
        for(int i=0;i<dist.length-1;i++){
            double d=dist[i];
            ans+=(Math.ceil(d/speed));
        }
        ans+=((1.0*dist[dist.length-1])/speed);
        return ans<=hour ? true:false;
    }
}