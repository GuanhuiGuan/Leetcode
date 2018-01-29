class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        List<Integer> re = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        while(!q.isEmpty()) {
            int k = q.poll();
            re.add(k);
            if(map.containsKey(k)) {
                List<Integer> list = map.get(k);
                q.addAll(list);
            }
        }
        return re;
    }
}