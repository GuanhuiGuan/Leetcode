class Solution {
    Map<Integer, List<int[]>> map = new TreeMap<>();
    Queue<int[]> heap;
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        
        // Treemap to store buildings at each spot
        initMap(buildings);
        
        // Heap to store buildings sorted with height descendingly
        heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        
        // Update heap when sweeping through
        for(int key: map.keySet()) {
            List<int[]> list = map.get(key);
            // update heap
            for(int[] building: list) {
                if(key == building[1])  heap.remove(building);
                else    heap.offer(building);
            }
            // update res
            if(heap.isEmpty())  res.add(new int[] {key, 0});
            else {
                int h = heap.peek()[2];
                // only add if empty or not same as before
                if(res.isEmpty() || res.get(res.size()-1)[1] != h)  res.add(new int[] {key, h});
            }
        }
        return res;
    }
    
    public void initMap(int[][] buildings) {
        for(int[] building: buildings) {
            map.putIfAbsent(building[0], new ArrayList<>());
            map.putIfAbsent(building[1], new ArrayList<>());
            map.get(building[0]).add(building);
            map.get(building[1]).add(building);
        }
    }
}