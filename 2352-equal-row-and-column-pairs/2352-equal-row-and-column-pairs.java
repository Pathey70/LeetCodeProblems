class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        int n=grid.length;
        for(int i=0;i<n;i++){
            List<Integer> li=new ArrayList<>();
            for(int j=0;j<n;j++){
                li.add(grid[i][j]);
            }
            map.put(li,map.getOrDefault(li,0)+1);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            List<Integer> li=new ArrayList<>();
            for(int j=0;j<n;j++){
                li.add(grid[j][i]);
            }
            ans+=map.getOrDefault(li,0);
        }
        return ans;
    }
}