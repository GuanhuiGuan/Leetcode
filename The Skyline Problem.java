class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // result
        List<int[]> re = new ArrayList<int[]>();
        // ordered a list of rectangles for each criticl points
        Map<Integer, List<int[]>> pts = new TreeMap<Integer, List<int[]>>();
        for(int[] bd: buildings){
            pts.putIfAbsent(bd[0], new ArrayList<>());
            pts.putIfAbsent(bd[1], new ArrayList<>());
            pts.get(bd[0]).add(bd);
            pts.get(bd[1]).add(bd);
        }
        // heap: ordered buildings by height(max heap)
        Queue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2){
                // reverse for maxheap
                return i2[2]-i1[2];
            }
        });
        
        // sweep through every pt
        for(Map.Entry<Integer, List<int[]>> pt: pts.entrySet()){
            int x = pt.getKey();
            List<int[]> bds = pt.getValue();
            
            // update heap with start
            for(int[] bd: bds){
                if(bd[0] == x){
                    heap.add(bd);
                }
                else{
                    heap.remove(bd);
                }
            }
            
            // get height(0 or maxh if no duplicate)
            if(heap.isEmpty()){
                re.add(new int[] {x, 0});
            }
            else{
                int height = heap.peek()[2];
                if(re.isEmpty() || re.get(re.size()-1)[1] != height){
                    re.add(new int[] {x, height});
                }
            }
        }
        
        return re;
    }
}
