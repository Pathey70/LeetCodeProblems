class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double sum=0;
        int count=0;
        int i=0;
        while(i<k){
            sum+=arr[i];
            i++;
        }
        if(sum/k>=threshold)
            count++;
        while(i<arr.length){
            sum+=arr[i];
            sum-=arr[i-k];
            if(sum/k>=threshold)
                count++;
            i++;
        }
        return count;
    }
}