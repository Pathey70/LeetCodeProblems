public class ZigzagIterator {

    Queue<int[]> queue;
    List<List<Integer>> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue=new LinkedList<>();
        list=new ArrayList<>();
        list.add(v1);
        list.add(v2);
        for(int i=0;i<list.size();i++)
        {
            List<Integer> li=list.get(i);
            if(li.size()>0)
            {
                int arr[]={0,i};
                queue.add(arr);
            }
        }
    }

    public int next() {
        int arr[]=queue.poll();
        int ret=list.get(arr[1]).get(arr[0]);
        arr[0]++;
        if(list.get(arr[1]).size()>arr[0])
        {
            queue.add(arr);
        }
        return ret;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */