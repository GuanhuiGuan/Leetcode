class Solution {
    
    Map<Character, Set<Character>> map = new HashMap<>();
    Map<Character, Integer> degree = new HashMap<>();
    
    //** Topological Sort *
    public String alienOrder(String[] words) {
        initChars(words);
        return sort();
    }
    
    public void initChars(String[] words) {
        for(String word: words) {
            for(char c: word.toCharArray()) degree.put(c, 0);
        }
        
        // For each neighboring pair of words, find first pair of chars not the same
        for(int i = 1; i < words.length; i++) {
            String w1 = words[i-1], w2 = words[i];
            for(int j = 0, k = 0; j < w1.length() && k < w2.length(); j++, k++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(k);
                if(c1 != c2) {
                    // add c2 as child to c1(if not added already)(avoid duplication), and increment c2's degree
                    Set<Character> set = map.get(c1) == null? new HashSet<>(): map.get(c1);
                    if(!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
    }
    
    //** Find those with 0 degree and decrement their children's degrees
    public String sort() {
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: degree.entrySet()) {
            if(entry.getValue() == 0)   queue.offer(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            Set<Character> children = map.get(c);
            if(children == null)    continue;
            for(char child: children) {
                degree.put(child, degree.get(child)-1);
                if(degree.get(child) == 0)  queue.offer(child);
            }
        }
        return sb.length() != degree.size()? "": sb.toString();
    }
}