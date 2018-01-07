class Solution {
    public String frequencySort(String s) {
        // __________map and bucket sort___________
        Map<Character, Integer> map = new HashMap<>();
        List<List<Character>> buckets = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            buckets.add(new ArrayList<>());
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) map.put(c, map.get(c)+1);
            else    map.put(c, 1);
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            buckets.get(entry.getValue()-1).add(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.size()-1; i >= 0; i--) {
            List<Character> list = buckets.get(i);
            if(!list.isEmpty()) {
                for(char c: list) {
                    for(int j = 0; j <= i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
        
        
        
//         // ____________map and priority queue_______________
//         Map<Character, Integer> map = new HashMap<>();
//         Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
//             public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                 return o2.getValue() - o1.getValue();
//             }
//         });
//         StringBuilder sb = new StringBuilder();
        
//         for(int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if(map.containsKey(c)) map.put(c, map.get(c)+1);
//             else    map.put(c, 1);
//         }
        
//         q.addAll(map.entrySet());
//         while(!q.isEmpty()) {
//             Map.Entry<Character, Integer> entry = q.poll();
//             int cnt = entry.getValue();
//             while(cnt != 0) {
//                 sb.append(entry.getKey());
//                 cnt--;
//             }
//         }
//         return sb.toString();
    }
}