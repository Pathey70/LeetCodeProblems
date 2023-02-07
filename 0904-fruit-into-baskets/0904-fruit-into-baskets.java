class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int right=0;
        int n=fruits.length;
        int max=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(right<fruits.length){
            int f=fruits[right];
            hm.put(f,hm.getOrDefault(f,0)+1);
            while(hm.size()>2){
                int freq=hm.get(fruits[left]);
                if(freq==1){
                    hm.remove(fruits[left]);
                }
                else{
                    hm.put(fruits[left],freq-1);
                }
                left++;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}