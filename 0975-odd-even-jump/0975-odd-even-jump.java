class Solution {
    public int oddEvenJumps(int[] arr) {
        int n=arr.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(arr[n-1],n-1);
        boolean end[][]=new boolean[n][2];
        end[n-1][0]=true;
        end[n-1][1]=true;
        int count=1;
        for(int i=n-2;i>=0;i--)
        {
            Map.Entry<Integer,Integer> leftMove=map.ceilingEntry(arr[i]);
            if(leftMove!=null&&end[leftMove.getValue()][1])
            {
                end[i][0]=true;
            }
            Map.Entry<Integer,Integer> rightMove=map.floorEntry(arr[i]);
            if(rightMove!=null&&end[rightMove.getValue()][0])
                end[i][1]=true;
            
            //System.out.println(leftMove+" "+rightMove);

            if(end[i][0])
                count++;
            map.put(arr[i],i);
        }
        return count;
    }
}