class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int arr[][] = new int[n][3];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=times[i][0];
            arr[i][1]=times[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        TreeMap<Integer,List<Integer>> endTimes=new TreeMap<>();
        TreeSet<Integer> availableChairs=new TreeSet<>();
        int c=0;
        for(int i=0;i<n;i++)
        {
            int start=arr[i][0];
            int end=arr[i][1];
            //System.out.println(start+" "+end);

            while(!endTimes.isEmpty())
            {
                int x1=endTimes.firstKey();
                if(x1<=start)
                {
                    List<Integer> li=endTimes.get(x1);
                    //System.out.println("Added "+x1);
                    endTimes.remove(x1);
                    for(int x:li)
                        availableChairs.add(x);
                }
                else{
                    break;
                }
            }
            int assignedChair=-1;
            //System.out.println(availableChairs);
            if(availableChairs.size()==0)
            {
                assignedChair = c;
                c++;
            }
            else{
                assignedChair = availableChairs.first();
                availableChairs.remove(assignedChair);
            }
            
            if(!endTimes.containsKey(end))
                endTimes.put(end,new ArrayList<Integer>());
            
            endTimes.get(end).add(assignedChair);
            //System.out.println(endTimes);
            if(arr[i][2]==targetFriend)
                return assignedChair;
        }
        return n;
    }
}