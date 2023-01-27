class Solution {
    public double[] sampleStats(int[] count) {
        double ans[]=new double[5];
        boolean minFlag=false;
        double total=0;
        double elements=0;
        int maxFreq=0;
        int maxFreqElement=0;
        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                if(!minFlag)
                {
                    ans[0]=i;
                    minFlag=!minFlag;
                }
                if(count[i]>maxFreq)
                {
                    maxFreq=count[i];
                    maxFreqElement=i;
                }
                ans[1]=i;
                //System.out.println(i+" "+count[i]);
                total+=(1.0*count[i]*(i));
                elements+=count[i];
            }
        }
        ans[2]=total/elements;
        
            double element1=-1;
            double element2=-1;
            double index=0;
            int i=0;
            while(element1<0||element2<0){
                index+=count[i];
                if(index>=(int)elements/2&&element1<0)
                    element1=i;
                if(index>=(int)elements/2+1&&element2<0)
                    element2=i;
              
                i++;
                
            }
        if(elements%2==0){
            ans[3]=(element1+element2)/2;
        }
        else{
            ans[3]=element2;
        }
        ans[4]=maxFreqElement;
        return ans;
    }
}