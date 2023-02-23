class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n=regular.length;
        long ans[]=new long[n];
        long reg[]=new long[n];
        long exp[]=new long[n];
        reg[0]=Math.min(regular[0],express[0]+expressCost);
        exp[0]=Math.min(express[0]+expressCost,regular[0]+expressCost);
        ans[0]=Math.min(reg[0],exp[0]);
        for(int i=1;i<n;i++){
            reg[i]=Math.min(reg[i-1]+regular[i],Math.min(exp[i-1]+express[i],reg[i-1]+expressCost+express[i]));
            exp[i]=Math.min(exp[i-1]+express[i],Math.min(reg[i-1]+regular[i]+expressCost,reg[i-1]+expressCost+express[i]));
            ans[i]=Math.min(reg[i],exp[i]);
        }
        return ans;
    }
}