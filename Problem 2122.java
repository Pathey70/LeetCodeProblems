/*
The idea is smallest element in the array would always be part of lower array so we can fix that element and iterate through rest of array to find possible
k values, k would be equal to (nums[i]-nums[0])/2, now the next step is to verify if the taken k value is correct or not. 
For that we iterate over the array again and check if nums[j]+2k or nums[j]-2k element is present or not if none of this entries are present then k value 
we have taken is incorrect and we can move to new k value. If the element were present then we decrease frequency in hashmap so we can keep track if it 
was already checked or not.

*/

class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1); //Stroing frequency of elements in hashmap
        }
        int ans[]=new int[nums.length/2];
        for(int i=1;i<nums.length;i++){
            int k=(nums[i]-nums[0])/2;  // Finding k values
            if(k==0)
                continue;    //K should be positive only
            HashMap<Integer,Integer> hm2=new HashMap<>(hm); //Making copy of original hashmap
            int index=0;
            for(int j=0;j<nums.length;j++){
                if(hm2.get(nums[j])>=1){
					//If element was not previously checked
                    if(hm2.getOrDefault(nums[j]+2*k,0)>=1){
                        ans[index]=nums[j]+k; //Original element is nums[j]+k
                        hm2.put(nums[j],hm2.get(nums[j])-1);
                        hm2.put(nums[j]+2*k,hm2.get(nums[j]+2*k)-1); // Decreasing frequency of both nums[j]&&nums[j]+k
                    }
                    else if(hm2.getOrDefault(nums[j]-2*k,0)>=1){
                        ans[index]=nums[j]-k;   //Original element was nums[j]-k
                        hm2.put(nums[j],hm2.get(nums[j])-1); 
                        hm2.put(nums[j]-2*k,hm2.get(nums[j]-2*k)-1); //Decreasing frequency of both nums[j]&&nums[j]+k
                        
                    }
                    else{
						//Invalid k value 
                        break;
                    }
                    index++;
                }
            }
            if(index==nums.length/2)
                break; //Found the solution
            
        }
        return ans;
    }
}
