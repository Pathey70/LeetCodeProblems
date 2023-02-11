class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int candy:candyType)
            hs.add(candy);
        return Math.min(candyType.length/2,hs.size());
    }
}