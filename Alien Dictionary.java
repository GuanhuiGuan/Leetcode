class Solution {
    public String alienOrder(String[] words) {
        String re = "";
        if(words.length == 0)   return re;
        
        // converge to DAG and topological sort
        // graphs and indegree(of all letters)
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                inDegree.put(word.charAt(i), 0);
            }
        }
        
        // compare every adjacent two words
        for(int i = 0; i < words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int len = Math.min(w1.length(), w2.length());
            // find the 1st different character
            for(int j = 0; j < len; j++){
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    // if c1 is added to graph
                    if(graph.containsKey(c1)){
                        set = graph.get(c1);
                    }
                    // if c1 not connected to c2
                    if(!set.contains(c2)){
                        set.add(c2);
                        graph.put(c1, set);
                        inDegree.put(c2, inDegree.get(c2)+1);
                    }
                    // those beyond may lead to wrong results
                    break;
                }
            }
        }
        
        // topological sort(Kahn's algorithm)
        Queue<Character> queue = new LinkedList<>();
        // 1. find 0-indegree
        for(char key: inDegree.keySet()){
            if(inDegree.get(key) == 0){
                queue.offer(key);
            }
        }
        // 2. find its neighbors, cut edges and insert if they have 0-indegree
        while(!queue.isEmpty()){
            char c = queue.poll();
            re += Character.toString(c);
            if(!graph.containsKey(c))   continue;
            Set<Character> g = graph.get(c);
            for(char cn: g){
                inDegree.put(cn, inDegree.get(cn)-1);
                if(inDegree.get(cn) == 0){
                    queue.offer(cn);
                }
            }
        }
        // 3. check if valid and output
        if(re.length() != inDegree.size())  return "";
        return re;
    }
}