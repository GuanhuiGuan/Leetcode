class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // Map to save count of edges at such distance x(distance from left edge)
        if(wall == null || wall.size() == 0)    return 0;
        int maxEdges = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list: wall) {
            int x = 0;
            // Ignore the very first and very end edge
            for(int i = 0; i < list.size()-1; i++) {
                x += list.get(i);
                map.put(x, map.getOrDefault(x, 0) + 1);
                maxEdges = Math.max(maxEdges, map.get(x));
            }
        }
        // Count of walls minus the count of maxEdges
        return wall.size() - maxEdges;
    }
}