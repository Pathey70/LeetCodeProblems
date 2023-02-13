class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums[0].length();
        HashSet<String> hs=new HashSet<>();
        for(String num:nums)
            hs.add(num);
        char arr[]=new char[n];
        Arrays.fill(arr, '0');
        String zero=new String(arr);
        if(!hs.contains(zero))
            return zero;
        int low=(int)Math.pow(2,n-1);
        int high=low*2;
        while(low<high){
            String s=Integer.toBinaryString(low);
            if(!hs.contains(s))
                return s;
            low++;
        }
        return "";
    }
}