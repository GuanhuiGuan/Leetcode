class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // Topological sort
        // 1. Create graph from seqs, next_map and indegree_map
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        Map<Integer, Integer> indMap = new HashMap<>();
        for(List<Integer> seq: seqs) {
            // single node
            if(seq.size() == 1) {
                if(!nextMap.containsKey(seq.get(0))) nextMap.put(seq.get(0), new ArrayList<>());
                if(!indMap.containsKey(seq.get(0))) indMap.put(seq.get(0), 0);
            }
            // paths
            else {
                for(int i = 0; i < seq.size()-1; i++) {
                    int cur = seq.get(i), next = seq.get(i+1);
                    List<Integer> nexts = nextMap.getOrDefault(cur, new ArrayList<>());
                    nexts.add(next);
                    nextMap.put(cur, nexts);
                    nextMap.put(next, nextMap.getOrDefault(next, new ArrayList<>()));
                    indMap.put(cur, indMap.getOrDefault(cur, 0));
                    indMap.put(next, indMap.getOrDefault(next, 0)+1);
                }
            }
        }
        
        // 2. Topological sort and check org path
        Queue<Integer> q = new LinkedList<>();
        for(int key: indMap.keySet()) {
            if(indMap.get(key) == 0)    q.offer(key);
        }
        int index = 0;
        while(!q.isEmpty()) {
            // need one unique path
            if(q.size() != 1)   return false;
            int cur = q.poll();
            // wrong path
            if(index >= org.length || cur != org[index])    return false;
            index++;
            for(int next: nextMap.get(cur)) {
                indMap.put(next, indMap.get(next)-1);
                if(indMap.get(next) == 0)   q.offer(next);
            }
        }
        // check length and cycle
        return index == org.length && index == indMap.size();
    }
}