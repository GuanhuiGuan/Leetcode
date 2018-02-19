package networkDelay;
import java.util.*;

class NetworkDelay {
    public int networkDelayTime(int[][] times, int N, int K) {
        // create graph, Dijkstra's algo
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] time: times) {
            // find sourceMap from each node
            Map<Integer, Integer> sourceMap = map.get(time[0]);
            if(sourceMap == null) {
                sourceMap = new HashMap<>();
                map.put(time[0], sourceMap);
            }
            // check if such connection is in sourceMap or is slower
            Integer curTime = sourceMap.get(time[1]);
            if(curTime == null || curTime > time[2]) {
                sourceMap.put(time[1], time[2]);
            }
        }
        
        // Dijkstra's
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(K, 0);
        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                return n1[1] - n2[1];
            }
        });
        heap.offer(new int[] {K, 0});
        
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            int node = cur[0];
            int delay = cur[1];
            
            // check if processed with less time
            if(dist.containsKey(node) && dist.get(node) < delay)   continue;
            
            Map<Integer, Integer> sourceMap = map.get(node);
            if(sourceMap == null)   continue;
            for(Map.Entry<Integer, Integer> entry: sourceMap.entrySet()) {
                int next = entry.getKey();
                int time = entry.getValue() + delay;
                // skip smaller or equal time
                if(dist.containsKey(next) && dist.get(next) <= time)   continue;
                dist.put(next, time);
                heap.offer(new int[] {next, time});
            }
        }
        
        // get max time of system
        int max = -1;
        for(int time: dist.values()) {
            if(max < time)  max = time;
        }
        
        // print the time for message to arrive at each node
        String s = "";
        for(int i = 1; i <= N; i++) {
        	s += i + ": ";
        	if(dist.containsKey(i))	s += dist.get(i) + "s\n";
        	else	s += -1 + "\n";
        }
        System.out.println(s);
        
        
        // check if all visited
        return dist.size() == N? max: -1;
    }
}
