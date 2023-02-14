class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        if(node1==node2){
            return node1;
        }
        map1.put(node1,0);
        map2.put(node2,0);
        boolean flag1=true;
        boolean flag2=true;
        int minD=Integer.MAX_VALUE;
        int minI=-1;
        while(flag1||flag2){
            if(flag1)
            {
                int t1=edges[node1];
                if(t1==-1||map1.containsKey(t1))
                    flag1=false;
                else 
                {
                    map1.put(t1,map1.get(node1)+1);
                    if(map2.containsKey(t1)){
                        int maxD=Math.max(map2.get(t1),map1.get(t1));
                        if(maxD<minD){
                            minI=t1;
                            minD=maxD;
                        }
                        if(maxD==minD)
                            minI=Math.min(minI,t1);
                    }
                    node1=t1;
                }
            }
            if(flag2)
            {
                int t2=edges[node2];
                if(t2==-1||map2.containsKey(t2))
                    flag2=false;
                else{
                    map2.put(t2,map2.get(node2)+1);
                    if(map1.containsKey(t2)){
                        int maxD=Math.max(map2.get(t2),map1.get(t2));
                        if(maxD<minD){
                            minI=t2;
                            minD=maxD;
                        }
                        if(maxD==minD)
                            minI=Math.min(minI,t2);
                    }
                    node2=t2;
                }
            }
        }
        return minI;
    }
}