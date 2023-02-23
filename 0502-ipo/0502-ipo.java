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
        /*Queue<Cap> queue=new PriorityQueue<>(profits.length,new ListComparator());
        for(int i=0;i<profits.length;i++){
            
                Cap cap=new Cap();
                cap.x=profits[i];
                cap.y=capital[i];
                queue.add(cap);
            
        }
        int i=0;
        while(i<k&&queue.size()>0){
            Stack<Cap> stack=new Stack<>();
            boolean found=false;
            while(true&&queue.size()>0){
               Cap cap=queue.poll();
            //   System.out.println(cap.x+" "+cap.y);
                if(cap.y<=w){
                    
                    found=true;
                    w+=cap.x;
                    break;
                }
                else{
                    stack.add(cap);
                }
            }
            if(found)
            {
                while(!stack.isEmpty()){
                    queue.add(stack.pop());
                }
                i++;
            }
            else
            {
                return w;
            }
        }
        return w;*/
    }
}
class Cap{
    int x;
    int y;
}
class ListComparator implements Comparator<Cap>{
    public int compare(Cap l1,Cap l2){
        return Integer.compare(l2.x,l1.x);
    }
}