class Solution {
    List<String> itinerary = new ArrayList<>();
    Map<String, Queue<String>> map = new HashMap<>();
    
    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket: tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
            // Queue<String> q = new PriorityQueue<>();
            // if(map.get(ticket[0]) != null) {
            //     q = map.get(ticket[0]);
            // }
            // q.add(ticket[1]);
            // map.put(ticket[0], q);
        }
        fly("JFK");
        return itinerary;
    }
    
    public void fly(String dpt) {
        // DFS, keep going if is departure and remaining destinations
        while(map.containsKey(dpt) && !map.get(dpt).isEmpty()) {
            fly(map.get(dpt).poll());
        }
        // insert to the top of the list
        itinerary.add(0, dpt);
    }
}