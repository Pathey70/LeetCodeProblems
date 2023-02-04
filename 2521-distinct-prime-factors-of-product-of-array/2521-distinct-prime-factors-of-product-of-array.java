class Solution {
    public int distinctPrimeFactors(int[] nums) {
       
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> hs1=prime(nums[i]);   
            hs.addAll(hs1);
        }
        return hs.size();
    }
    public HashSet<Integer> prime(int x1){
        HashSet<Integer> hs=new HashSet<>();
        if(isPrime(x1))
        {
            hs.add(x1);
            return hs;
        }
        for(int i=(int)Math.sqrt(x1);i>1;i--){
            if(x1%i==0)
            {
                if(isPrime(i)){
                    hs.add(i);
                }
                if(isPrime(x1/i))
                    hs.add(x1/i);
            }
        }
        return hs;
    }
    public boolean isPrime(int x1){
        for(int i=(int)Math.sqrt(x1);i>1;i--){
            if(x1%i==0)
                return false;
        }
        return true;
    }
    
}