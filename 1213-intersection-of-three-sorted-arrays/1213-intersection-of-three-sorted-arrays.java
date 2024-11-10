class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans=new ArrayList<>();
        int i=0;
        int i1=0;
        int i2=0;
        int i3=0;
        while(i1<arr1.length&&i2<arr2.length&&i3<arr3.length)
        {
            if(arr1[i1]==arr2[i2]&&arr3[i3]==arr2[i2])
            {
                ans.add(arr1[i1]);
            }
            int max=Math.max(arr1[i1],Math.max(arr2[i2],arr3[i3]));
            boolean done=false;
            if(arr1[i1]<max)
            {
                i1++;
                done=true;
            }
            if(arr2[i2]<max)
            {
                i2++;
                done=true;
            }
            if(arr3[i3]<max)
            {
                i3++;
                done=true;
            }
            if(!done)
            {
                i1++;
                i2++;
                i3++;
            }
        }
        return ans;
    }
}