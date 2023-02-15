class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> l1=new ArrayList<Integer>();
        int i=0;
        List<Integer> l2=new ArrayList<Integer>();
        while(i<nums.length&&nums[i]<0){
            l1.add(nums[i]);
            i++;
        }
        while(i<nums.length){
            l2.add(nums[i]);
            i++;
        }
        int j=0;
        int s1=l1.size()-1;
        int s2=0;
        while(j<nums.length){
            int n1=s1>=0 ?  l1.get(s1)*l1.get(s1):Integer.MAX_VALUE;
            int n2=s2<l2.size() ?  l2.get(s2)*l2.get(s2):Integer.MAX_VALUE;
            if(n1<n2)
            {
                nums[j]=n1;
                s1--;
            }
            else{
                nums[j]=n2;
                s2++;
            }
            j++;
        }
        return nums;
    }
}