class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int index=0;
        Queue<Integer> queue=new PriorityQueue<>(k,Collections.reverseOrder());
        int total=0;
        long c=w;
        for(int i=0;i<k;i++){
            while(index<n&&arr[index][0]<=c){
                queue.add(arr[index][1]);
                index++;
            }
            if(!queue.isEmpty()){
                int t=queue.poll();
                c+=t;
                total+=t;
            }
        }
        return (int)c;
      
    }
}
